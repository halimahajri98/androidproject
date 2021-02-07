package com.example.lampstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_grid_item extends AppCompatActivity {
    TextView name ;
    ImageView image;
    Button btnbtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);
        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageView);
        btnbtn = findViewById(R.id.btnbtn);

        btnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_grid_item.this , formulaire.class);
                startActivity(intent);

            }

        });

        Intent i = getIntent();
        name.setText(i.getStringExtra("name"));
        image.setImageResource(((Intent) i).getIntExtra("image" , 0));
    }
}