package com.example.monitoracelerometro;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor acelerometro;

    private TextView txtStatus;
    private TextView txtX;
    private TextView txtY;
    private TextView txtZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStatus = findViewById(R.id.txtStatus);
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtZ = findViewById(R.id.txtZ);

        sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);

        acelerometro = sensorManager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER
        );

        if (acelerometro == null) {
            txtStatus.setText(
                    "Acelerômetro não disponível neste dispositivo."
            );
        } else {
            txtStatus.setText(
                    "Sensor encontrado. Movimente o aparelho."
            );
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (acelerometro != null) {

            boolean registrado = sensorManager.registerListener(
                    this,
                    acelerometro,
                    SensorManager.SENSOR_DELAY_UI
            );

            if (!registrado) {
                txtStatus.setText(
                        "Não foi possível iniciar a leitura."
                );
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            // Capturar os valores dos três eixos
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Atualizar os valores na tela
            txtX.setText(String.format(
                    Locale.getDefault(),
                    "Eixo X: %.2f m/s²", x
            ));

            txtY.setText(String.format(
                    Locale.getDefault(),
                    "Eixo Y: %.2f m/s²", y
            ));

            txtZ.setText(String.format(
                    Locale.getDefault(),
                    "Eixo Z: %.2f m/s²", z
            ));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
  }

    @Override
    protected void onPause() {
        super.onPause();

        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }
}