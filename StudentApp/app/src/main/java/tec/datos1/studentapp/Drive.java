package tec.datos1.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Drive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = intent.getStringExtra(Map.EXTRA_MESSAGE1);
        String message2 = intent.getStringExtra(Map.EXTRA_MESSAGE2);

        // Capture the layout's TextView and set the string as its text
        TextView text1 = findViewById(R.id.txt1);
        text1.setText(message1);

        TextView text9 = findViewById(R.id.txt9);
        text9.setText(message2);
    }
}
