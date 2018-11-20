package tec.datos1.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Map extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "tec.datos1.studentapp.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "tec.datos1.studentapp.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    public void sendInfo (View view){
        Intent intent = new Intent(this, Drive.class);
        EditText txtSalida = findViewById(R.id.txtSalida);
        String ptoSalida = txtSalida.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, ptoSalida);

        EditText txtDestino = findViewById(R.id.txtDestino);
        String ptoDestino = txtDestino.getText().toString();
        intent.putExtra(EXTRA_MESSAGE2, ptoDestino);

        startActivity(intent);
    }

}
