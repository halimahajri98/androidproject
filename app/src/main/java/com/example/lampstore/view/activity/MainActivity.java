package com.example.lampstore.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lampstore.R;


/*
* ##################################Classes Naming##########################################
* Try always to name classes using CamelCase method (Every first character of the class name must be capital)
* Always add the word 'Activity' or 'Fragment' to reach better understanding of the elements of the project
* */
public class MainActivity extends AppCompatActivity {
    Button sq ;
    Button btnuser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sq = (Button)findViewById(R.id.squares);
        btnuser=  (Button)findViewById(R.id.btnuser);

        sq.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this , ProductsActivity.class);
            startActivity(intent);

        });

        btnuser.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this , ProfileActivity.class);
            startActivity(intent1);


        });
    }

}