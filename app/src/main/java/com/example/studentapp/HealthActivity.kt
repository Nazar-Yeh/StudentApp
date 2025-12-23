package com.example.studentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class HealthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health)

        val btnMian = findViewById<Button>(R.id.button2)
        btnMian.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
        }
    }
}