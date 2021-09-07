package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button getGPSBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getGPSBtn = (Button) findViewById(R.id.getGPSBtn);
        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if (l != null) {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: " + lat + "\nLONG: " +
                            longi, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}