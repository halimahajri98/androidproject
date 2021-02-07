package com.example.lampstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class paiement extends AppCompatActivity {
    RadioButton btncard , btcard;
    Button btnpaiement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement);

        btncard =findViewById(R.id.cardd);
        btcard = findViewById(R.id.card);
        btnpaiement = findViewById(R.id.butpaiement);



       btnpaiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btcard.isChecked()){
                    Intent intent = new Intent(paiement.this , paiement.class);
                    startActivity(intent);
                }

            }
        });



    }
}