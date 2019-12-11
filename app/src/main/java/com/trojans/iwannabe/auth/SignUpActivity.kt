package com.trojans.iwannabe.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.trojans.iwannabe.R
import com.trojans.iwannabe.navigation.NavigationActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        findViewById<Button>(R.id.btnLogin).setOnClickListener { goToNewInstructionsFragment() }
    }

    private fun goToNewInstructionsFragment() {
        startActivity(Intent(this, NavigationActivity::class.java))
        finish()
    }
}
