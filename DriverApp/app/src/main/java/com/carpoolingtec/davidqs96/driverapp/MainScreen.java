package com.carpoolingtec.davidqs96.driverapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    private Button profileEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        profileEdit = (Button) findViewById(R.id.btn_profileEdit);
        profileEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openProfile();
            }

        });
    }

    public void openProfile(){
        Intent intent = new Intent(this, ProfileScreen.class);
        startActivity(intent);
    }

}
