package com.carpoolingtec.davidqs96.driverapp;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;


public class StartTrip extends AppCompatActivity {

    TextView txtInicio;
    TextView txtFin;
    TextView Tiempo;
    Button btnTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_trip);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(NewTripScreen.EXTRA_MESSAGE1);
        String message2 = intent.getStringExtra(NewTripScreen.EXTRA_MESSAGE2);

        // Capture the layout's TextView and set the string as its text
        txtInicio = findViewById(R.id.txtInicio);
        txtInicio.setText(message1);

        txtFin = findViewById(R.id.txtFin);
        txtFin.setText(message2);
    }

    public void nextPerson(){
        //Le pide al servidor quien sigue
    }

    public void endTrip(){
        //Termina el viaje
    }

    public void timeTrip(View view){
        //Le pide al servidor el tiempo que va a durar
        //Muestra el tiempo en pantalla
        String URL = "http://172.18.35.160:9080/CarpoolingTECServer/connect/request";
        String ptoSalida = txtInicio.getText().toString();
        String ptoDestino = txtFin.getText().toString();

        String all = ptoSalida + "," + ptoDestino;

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Vivihola", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Vivihola", error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);

    }

}
