package com.example.ihc_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AskMessage extends AppCompatActivity {

    private Button btn;
    private TextView field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        field = findViewById(R.id.textInfo);
        field.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }
        });

    }

    public void onClick(View view) {
        Intent newActivity = new Intent(AskMessage.this, ShowMessage.class);
        TextView infoText = findViewById(R.id.textInfo);
        newActivity.putExtra("TEXT_INFO", infoText.getText().toString());
        startActivity(newActivity);
    }
}
