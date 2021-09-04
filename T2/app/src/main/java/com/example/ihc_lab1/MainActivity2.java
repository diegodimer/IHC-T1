package com.example.ihc_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String textInfo = getIntent().getStringExtra("TEXT_INFO");
        TextView txtView = (TextView) findViewById(R.id.textView);
        txtView.setText(textInfo);


    }

}