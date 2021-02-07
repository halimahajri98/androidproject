package com.example.lampstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class formulaire extends AppCompatActivity {
    Button btnsend ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);
        btnsend = findViewById(R.id.butnsend);


        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(formulaire.this , paiement.class);
                startActivity(intent);

            }

        });
    }
}