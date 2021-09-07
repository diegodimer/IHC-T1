package com.example.tempsensor;


import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light;
    private Sensor temperature;
    TextView lightValue;
    TextView temperatureValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = (TextView)findViewById(R.id.light);
        temperatureValue = (TextView)findViewById(R.id.temp);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }
        if(temperature != null)
        {
            sensorManager.registerListener(MainActivity.this, temperature,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            temperatureValue.setText("Temperature sensor not supported");
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
            temperatureValue.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

}