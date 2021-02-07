package com.example.lampstore.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lampstore.R;

public class FormActivity extends AppCompatActivity {
    Button btnsend ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);
        btnsend = findViewById(R.id.butnsend);


        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormActivity.this , PaymentActivity.class);
                startActivity(intent);

            }

        });
    }
}