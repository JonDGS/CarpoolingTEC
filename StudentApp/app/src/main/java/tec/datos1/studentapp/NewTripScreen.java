package tec.datos1.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewTripScreen extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "tec.datos1.studentapp.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "tec.datos1.studentapp.MESSAGE2";
    EditText txtSalida;
    EditText txtDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip_screen);
    }

    public void cancelTrip(View view){
        finish();
    }

    public void startTrip(View view){
        //Le manda al servidor el inicio y fin de su viaje
        //Recibe la información del viaje y hace una lista de los caminos
        //Recibe algunos viajes con respecto a su camino
        //Solicita el tiempo de duración
        Intent intent = new Intent(this, StartTrip.class);

        txtSalida = findViewById(R.id.txtSalida);
        String ptoSalida = txtSalida.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, ptoSalida);

        txtDestino = findViewById(R.id.txtDestino);
        String ptoDestino = txtDestino.getText().toString();
        intent.putExtra(EXTRA_MESSAGE2, ptoDestino);

        startActivity(intent);
    }
}
