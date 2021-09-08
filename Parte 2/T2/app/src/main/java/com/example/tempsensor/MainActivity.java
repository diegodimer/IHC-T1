package com.example.tempsensor;


import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light;
    private Sensor gyroscope;
    private Sensor temperature;
    TextView lightValue;
    TextView temperatureValue;
    TextView gyroscopeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = (TextView)findViewById(R.id.light);
        gyroscopeValue = (TextView)findViewById(R.id.gyroscope);
        temperatureValue = (TextView)findViewById(R.id.temp);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }
        if(gyroscope != null)
        {
            sensorManager.registerListener(MainActivity.this, gyroscope,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            gyroscopeValue.setText("Gyroscope sensor not supported");
        }
        if(temperature != null)
        {
            sensorManager.registerListener(MainActivity.this, temperature,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            gyroscopeValue.setText("Temperature sensor not supported");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if( sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText(String.valueOf(sensorEvent.values[0]));
        }
        if( sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE)
        {
            gyroscopeValue.setText(String.valueOf(sensorEvent.values[0]));
        }
        if( sensorEvent.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            temperatureValue.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

}