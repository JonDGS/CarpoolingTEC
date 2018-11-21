package com.carpoolingtec.davidqs96.driverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ProfileScreen extends AppCompatActivity {
    SingletonClass singleton = SingletonClass.getSingleton();

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
        setContentView(R.layout.activity_profile_screen);

        name = (EditText) findViewById(R.id.tbx_name);
        name.setText(singleton.getDriver().getName());

        surname = (EditText) findViewById(R.id.tbx_surname);
        surname.setText(singleton.getDriver().getSurname());

        id = (EditText) findViewById(R.id.tbx_id);
        id.setText(singleton.getDriver().getId());

        placeResidence = (EditText) findViewById(R.id.tbx_placeResidence);
        placeResidence.setText(singleton.getDriver().getPlaceResidence());

        brand = (EditText) findViewById(R.id.tbx_brand);
        brand.setText(singleton.getVehicle().getBrand());

        model = (EditText) findViewById(R.id.tbx_model);
        model.setText(singleton.getVehicle().getModel());

        licensePlate = (EditText) findViewById(R.id.tbx_licensePlate);
        licensePlate.setText(singleton.getVehicle().getLicensePlate());
    }
}
