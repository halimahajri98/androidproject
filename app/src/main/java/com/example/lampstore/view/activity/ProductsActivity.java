package com.example.lampstore.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lampstore.R;

public class ProductsActivity extends AppCompatActivity {
GridView gridView ;
String[] produitsNames= {"White Fabric Shade table lamp","Blue shade table lamp with Gold Base",
        "Balck Shade & Black Base","Multicolor Shade table lamp with Brown Base",
        "Floret Black Shade & Beig Base","Black Shade & Glass Base",
         "Red Terracotta Handpainted Warli Matki Table Lamp","Bequethal Beige Fabric & Gold Base",
        "Drum Designer off White Cotton","White Shade & Brown Base ",""};

int [] produitsImages = {R.drawable.tl1 , R.drawable.tl2, R.drawable.tl3,R.drawable.tl4,
        R.drawable.tl5,R.drawable.tl6,R.drawable.tl7,R.drawable.tl8 ,
        R.drawable.tl9, R.drawable.tl10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);

        gridView = findViewById(R.id.gridView);

        CustomAdapter customadapter = new CustomAdapter();
        gridView.setAdapter(customadapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
               intent.putExtra("name", produitsNames[0]);
               intent.putExtra("image", produitsImages[0]);
               startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return produitsImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data ,null);

            TextView name = view1.findViewById(R.id.categorieslamp);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(produitsNames[0]);
            image.setImageResource(produitsImages[0]);
            return view1 ;
        }
    }
}