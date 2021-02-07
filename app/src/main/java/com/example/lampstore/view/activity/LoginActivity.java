package com.example.lampstore.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lampstore.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView circle1;
    ImageButton btRegister;
    TextView tvLogin;
    Button buttonlog;
    EditText username, password;
    FirebaseAuth mFirebaseAuth;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btRegister = findViewById(R.id.btRegister);
        tvLogin = findViewById(R.id.tvLogin);
        circle1 = findViewById(R.id.circle1);
        buttonlog = findViewById(R.id.buttonlog);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);

        mFirebaseAuth = FirebaseAuth.getInstance();
        activity = this;


        btRegister.setOnClickListener((View.OnClickListener) this);
        buttonlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.w("FIREBASE", "" + username.getText()+" "+password.getText());
                if (!validate("" + username.getText())) {
//                    Toast.makeText(activity, "Email nn valid", Toast.LENGTH_LONG).show();
                    Log.w("EMAIL_PASS", "Email nn valid");
                }
                else if (password.getText().length() < 6){
                    Log.w("ERROR_PASS", "password must be > 6");
                } else{
                    mFirebaseAuth.signInWithEmailAndPassword("" + username.getText(), "" + password.getText())
                            .addOnCompleteListener(activity, task -> {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("signInWithEmail", "signInWithEmail:success");
                                    FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                    startActivity(new Intent(activity, ProfileActivity.class));
                                    finish();
//                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("FAILER AUTH", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                    // ...
                                }
//
                            });
//                Log.w("FIREBASE", mFirebaseAuth.getCurrentUser());
//                Toast.makeText(getApplicationContext(), "" + mFirebaseAuth.getUid(),Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v == btRegister) {
            Intent a = new Intent(LoginActivity.this, SignUpActivity.class);
            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(tvLogin, "login");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
            startActivity(a, activityOptions.toBundle());
        }
    }


}