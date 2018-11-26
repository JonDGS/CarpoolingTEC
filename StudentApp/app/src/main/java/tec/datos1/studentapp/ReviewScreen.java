package tec.datos1.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReviewScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_screen);
    }

    public void exit(View view){
        finish();
    }

    public void again(View view){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
