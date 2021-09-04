package com.example.ihc_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView f1 = findViewById(R.id.fieldOne);
        TextView f2 = findViewById(R.id.fieldTwo);
        TextView result = findViewById(R.id.resultBox);
        int v1 = Integer.parseInt(f1.getText().toString());
        int v2 = Integer.parseInt(f2.getText().toString());
        result.setText(String.valueOf(v1+v2));
    }
}