package com.carpoolingtec.davidqs96.driverapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ProfileScreen extends AppCompatActivity {
    private SingletonClass singleton = SingletonClass.getSingleton();
    private Driver driver = singleton.getDriver();
    private Vehicle vehicle = singleton.getVehicle();

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken accessToken;
    private ProfileTracker profileTracker;

    private EditText name;
    private EditText surname;
    private EditText id;
    private EditText placeResidence;
    private EditText brand;
    private EditText model;
    private EditText licensePlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_profile_screen);

        name = (EditText) findViewById(R.id.tbx_name);
        name.setText(driver.getName());

        surname = (EditText) findViewById(R.id.tbx_surname);
        surname.setText(driver.getSurname());

        id = (EditText) findViewById(R.id.tbx_id);
        id.setText(driver.getId());

        placeResidence = (EditText) findViewById(R.id.tbx_placeResidence);
        placeResidence.setText(driver.getPlaceResidence());

        brand = (EditText) findViewById(R.id.tbx_brand);
        brand.setText(vehicle.getBrand());

        model = (EditText) findViewById(R.id.tbx_model);
        model.setText(vehicle.getModel());

        licensePlate = (EditText) findViewById(R.id.tbx_licensePlate);
        licensePlate.setText(vehicle.getLicensePlate());

        loginButton = (LoginButton) findViewById(R.id.btn_signInFacebook);
        callbackManager = CallbackManager.Factory.create();

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
            }
        };
        // If the access token is available already assign it.
        accessToken = AccessToken.getCurrentAccessToken();

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    Profile oldProfile,
                    Profile currentProfile) {
            }
        };

        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        loginWithFacebook();

    }

    public void saveProfile(View view){
        driver.setName(name.getText().toString());
        driver.setSurname(surname.getText().toString());
        driver.setId(id.getText().toString());
        driver.setPlaceResidence(placeResidence.getText().toString());
        driver.checkInfoFilled();

        vehicle.setBrand(brand.getText().toString());
        vehicle.setModel(model.getText().toString());
        vehicle.setLicensePlate(licensePlate.getText().toString());
        vehicle.checkInfoFilled();

        finish();
    }

    public void openBarcodeReader(View view){
        Intent intent = new Intent(this, BarcodeReaderScreen.class);
        startActivity(intent);

    }

    public void handleLinkedInLogin(View view){
        LISessionManager.getInstance(getApplicationContext()).init(this, buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.
                fetchPersonalInfoLinkedIn();
            }

            @Override
            public void onAuthError(LIAuthError error) {
                // Handle authentication errors
                Log.e("ProfileScreen", error.toString());
            }
        }, true);
    }

    // Build the list of member permissions our LinkedIn session requires
    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE);
    }

    private void handleLogout(){
        LISessionManager.getInstance(getApplicationContext()).clearSession();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // Add this line to your existing onActivityResult() method
//        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
//    }

    private void fetchPersonalInfoLinkedIn(){
        String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name)";

        APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
        apiHelper.getRequest(this, url, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {
                // Success!
                try {
                    JSONObject jsonObject = apiResponse.getResponseDataAsJson();

                    //Aqui se envía json al servidor

                    driver.setName(jsonObject.getString("firstName"));
                    name = (EditText) findViewById(R.id.tbx_name);
                    name.setText(driver.getName());

                    driver.setSurname(jsonObject.getString("lastName"));
                    surname = (EditText) findViewById(R.id.tbx_surname);
                    surname.setText(driver.getSurname());

                    driver.checkInfoFilled();
                    driver.setRegisteredWith("LinkedIn");

                } catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onApiError(LIApiError liApiError) {
                // Error making GET request!
                Log.e("ProfileScreen", liApiError.getMessage());
            }
        });
    }


    private void loginWithFacebook(){
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        //Toast.makeText(getApplicationContext(), "Se registró con éxito.", Toast.LENGTH_SHORT).show();
                        Profile profile = Profile.getCurrentProfile();

                        if (profile != null){
                            Toast.makeText(getApplicationContext(), "nombre " + profile.getFirstName().toString(), Toast.LENGTH_SHORT).show();
                            driver.setName(profile.getFirstName().toString());
                            name = (EditText) findViewById(R.id.tbx_name);
                            name.setText(driver.getName());

                            driver.setSurname(profile.getLastName().toString());
                            surname = (EditText) findViewById(R.id.tbx_surname);
                            surname.setText(driver.getSurname());

                            driver.checkInfoFilled();
                            driver.setRegisteredWith("Facebook");
                        }
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Login cancelado.", Toast.LENGTH_SHORT).show();
                        LoginManager.getInstance().logOut();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getApplicationContext(), "Se dió un error durante el login.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        LoginManager.getInstance().logOut();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();

        super.onDestroy();
    }
}
