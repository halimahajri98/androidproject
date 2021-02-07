package com.example.lampstore.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.lampstore.R;
import com.google.firebase.auth.FirebaseAuth;

public class LauncherActivity extends AppCompatActivity {

    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        // Testing if the user is already logged in or not
        if (firebaseAuth != null && firebaseAuth.getCurrentUser() != null){
            //Firebase sends infos so quickly so we need to slow down things to show progress bar effect by using Handler:)
            new Handler().postDelayed(() -> startActivity(new Intent(this, MainActivity.class)), 5000);

        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}