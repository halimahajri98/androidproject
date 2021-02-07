package com.example.lampstore.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lampstore.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    RelativeLayout rlayout;
    Animation animation;
    EditText usernamee, useremail, userpass, userpasspass;
    Button signup;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        usernamee = findViewById(R.id.username);
        useremail = findViewById(R.id.email);
        userpass = findViewById(R.id.pass);
        userpasspass = findViewById(R.id.passpass);

        signup = findViewById(R.id.signup);

        mFirebaseAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(v -> {
                String email = useremail.getText().toString().trim();
                String pass = userpass.getText().toString().trim();
                String passpass = userpasspass.getText().toString().trim();
                String username = usernamee.getText().toString().trim();

                if (email.equals("")) {
                    useremail.setError("please enter your email ... ");
                    useremail.requestFocus();
                    return;
                } else if (username.equals("")) {
                    usernamee.setError("please enter your username ... ");
                    usernamee.requestFocus();
                    return;
                } else if (pass.equals("")) {
                    userpass.setError("please enter your password ... ");
                    userpass.requestFocus();
                    return;
                } else if (passpass.equals("")) {
                    userpasspass.setError("please enter your password ... ");
                    userpasspass.requestFocus();
                    return;
                } else if (!pass.equals(passpass)) {
                    userpasspass.setError("Password Didn't match !!");
                    userpasspass.requestFocus();
                    return;
                } else {
                    mFirebaseAuth.createUserWithEmailAndPassword("" + useremail.getText(), "" + userpass.getText())
                            .addOnCompleteListener(SignUpActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                    Log.d("SUCCESS_SIGN", "createUserWithEmail:success" + mFirebaseAuth.getCurrentUser());
                                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                    finish();
//                                        updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("ERROR_SIGN", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                                        updateUI(null);
                                }

                                // ...
                            });
                }

        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
