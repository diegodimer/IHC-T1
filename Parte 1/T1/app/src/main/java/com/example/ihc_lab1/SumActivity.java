package com.example.ihc_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SumActivity extends AppCompatActivity {

    private TextView f1;
    private TextView f2;
    private TextView result;
    private Button btn;
    boolean f1Filled = false;
    boolean f2Filled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1 = findViewById(R.id.fieldOne);
        f2 = findViewById(R.id.fieldTwo);
        result = findViewById(R.id.resultBox);
        btn = findViewById(R.id.btn);

        f1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    f1Filled = true;
                else
                    f1Filled = false;
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(f1Filled && f2Filled)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            };
        });

        f2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    f2Filled = true;
                else
                    f2Filled = false;
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(f1Filled && f2Filled)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            };
        });
    }

    public void onClick(View view) {
        int v1 = Integer.parseInt(f1.getText().toString());
        int v2 = Integer.parseInt(f2.getText().toString());
        result.setText(String.valueOf(v1+v2));
    }


}