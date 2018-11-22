package com.carpoolingtec.davidqs96.driverapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StartTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_trip);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(NewTripScreen.EXTRA_MESSAGE1);
        String message2 = intent.getStringExtra(NewTripScreen.EXTRA_MESSAGE2);

        // Capture the layout's TextView and set the string as its text
        TextView txtInicio = findViewById(R.id.txtInicio);
        txtInicio.setText(message1);

        TextView txtFin = findViewById(R.id.txtFin);
        txtFin.setText(message2);
    }

    public void nextPerson(){
        //Le pide al servidor quien sigue
    }
}
