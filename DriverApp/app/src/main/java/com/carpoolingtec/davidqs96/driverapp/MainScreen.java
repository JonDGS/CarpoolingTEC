package com.carpoolingtec.davidqs96.driverapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {
    SingletonClass singleton = SingletonClass.getSingleton();
    private Button profileEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        profileEdit = (Button) findViewById(R.id.btn_profileEdit);
    }

    public void openProfile(View view){
        Intent intent = new Intent(this, ProfileScreen.class);
        startActivity(intent);
    }

    public void newTrip(View view){
        if(singleton.getDriver().isInfoFilled() && singleton.getVehicle().isInfoFilled()) {
            Intent intent = new Intent(this, NewTripScreen.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Primero llene su perfil.", Toast.LENGTH_SHORT).show();
        }
    }

    public void exitApp(View view) {
        finish();
        System.exit(0);
    }

}
