package com.carpoolingtec.davidqs96.driverapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

//Code obtained from: https://www.youtube.com/watch?v=ej51mAYXbKs

public class BarcodeReaderScreen extends AppCompatActivity {
    private SingletonClass singleton = SingletonClass.getSingleton();
    private Driver driver = singleton.getDriver();

    private SurfaceView surfaceView;
    private CameraSource cameraSource;
    private TextView textView;
    private BarcodeDetector barcodeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_reader_screen);

        surfaceView = (SurfaceView) findViewById(R.id.sfv_cameraPreview);
        textView = (TextView) findViewById(R.id.txv_focusMessage);

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.CODE_128)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(400, 400)
                .setAutoFocusEnabled(true)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getApplicationContext(), "Permiso para uso de cámara denegado. Intente habilitar permiso en los ajustes del sistema.", Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    cameraSource.start(surfaceHolder);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> codes128 = detections.getDetectedItems();

                if(codes128.size() != 0){
                    final String stringDetected = codes128.valueAt(0).displayValue;
                    if (stringDetected.matches("[0-9]+")){
                        //No entiendo porque el textView ... es necesario para que se escriba el código en el espacio de carnet
                        //como yo lo quería, pero si funciona xD (es decir, que sólo con el codigo dentro de run no es suficiente)
                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                                vibrator.vibrate(100);

                                driver.setId(stringDetected);

                                setContentView(R.layout.activity_profile_screen);
                                EditText idField = (EditText) findViewById(R.id.tbx_id);
                                idField.setText(stringDetected);

                            }
                        });
                    }
                }
            }
        });

    }
}
