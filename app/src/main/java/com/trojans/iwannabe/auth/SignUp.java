package com.trojans.iwannabe.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.trojans.iwannabe.R;
import com.trojans.iwannabe.home.HomeFragment;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fragment_container, new InstructionsFragment())
//                .commit();
        Button loginButton = findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(v -> goToNewInstructionsFragment());
    }

    private void goToNewInstructionsFragment() {
        startActivity(new Intent(this, HomeFragment.class));
    }
}
