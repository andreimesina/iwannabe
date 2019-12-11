package com.trojans.iwannabe.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.trojans.iwannabe.R
import com.trojans.iwannabe.navigation.NavigationActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUsername = findViewById<EditText>(R.id.login_field)
        val editTextPassword = findViewById<EditText>(R.id.password_field)
        val btnLogin = findViewById<Button>(R.id.login_button)
        val btnSignUp = findViewById<Button>(R.id.sign_up_button)

        btnLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username == "Teia" && password == "asd") {
                goToHomeFragment()
            } else {
                Toast.makeText(applicationContext, "Wrong username or password", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        btnSignUp.setOnClickListener { goToSignUp() }
    }

    private fun goToHomeFragment() {
        startActivity(Intent(this, NavigationActivity::class.java))
        finish()
    }

    private fun goToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
}