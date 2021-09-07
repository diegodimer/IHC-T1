package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SensorDataActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView textXField;
    private TextView textYField;
    private TextView textZField;

    private boolean sensorInitialized = false;
    double initialX, initialY, initialZ;
    double threshold = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textXField = findViewById(R.id.textX);
        textYField = findViewById(R.id.textY);
        textZField = findViewById(R.id.textZ);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            double bx, by, bz;
            double deltaX, deltaY, deltaZ;

            if(!sensorInitialized) {
                initialX = event.values[0];
                initialY = event.values[1];
                initialZ = event.values[2];
                sensorInitialized = true;

            }
            else {
                bx = event.values[0];
                by = event.values[1];
                bz = event.values[2];

                deltaX = Math.abs(bx - initialX);
                deltaY = Math.abs(by - initialY);
                deltaZ = Math.abs(bz - initialZ);

                textXField.setText(String.valueOf(deltaX));
                textYField.setText(String.valueOf(deltaY));
                textZField.setText(String.valueOf(deltaZ));

                if (deltaX > threshold || deltaY > threshold || deltaZ > threshold && sensorInitialized) {
                    Intent intent = new Intent(this, ShowMessageActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    sensorInitialized = false;
                }
            }
        }
    }
}