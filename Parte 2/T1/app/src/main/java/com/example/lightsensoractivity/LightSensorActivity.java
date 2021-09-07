package com.example.lightsensoractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light;
    TextView lightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = (TextView)findViewById(R.id.light);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        lightValue.setText(String.valueOf(light.getPower()));
        if(light != null)
        {
            sensorManager.registerListener(LightSensorActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);


        }else
        {
            lightValue.setText("Light sensor not supported");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if( sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
    }
}