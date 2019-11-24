package com.trojans.iwannabe.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.trojans.iwannabe.R;
import com.trojans.iwannabe.navigation.NavigationActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final EditText loginField = findViewById(R.id.login_field);
        final EditText passField = findViewById(R.id.password_field);
        Button loginButton = findViewById(R.id.login_button);
        Button signupButton = findViewById(R.id.sign_up_button);

        loginButton.setOnClickListener(v -> {
            String login = loginField.getText().toString();
            String password = passField.getText().toString();
            if (login.equals("Teia") && password.equals("asd")) {
                goToHomeFragment();
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Login or Password!", Toast.LENGTH_SHORT).show();
            }
        });

        signupButton.setOnClickListener(v -> goToSignUp());
    }

    private void goToHomeFragment() {
        startActivity(new Intent(this, NavigationActivity.class));
        finish();
    }

    private void goToSignUp() {
        startActivity(new Intent(this, SignUp.class));
    }
}