package tec.datos1.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void openProfile(View view){
        Intent intent = new Intent(this, ProfileScreen.class);
        startActivity(intent);
    }

    public void newTrip(View view){
        Intent intent = new Intent(this, NewTripScreen.class);
        startActivity(intent);
    }

    public void exitApp(View view){
        finish();
        System.exit(0);
    }
}
