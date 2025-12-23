package com.example.studentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnId = findViewById<Button>(R.id.btn_id_card)
        val btnMis = findViewById<Button>(R.id.btn_missions)
        val btnHeal = findViewById<Button>(R.id.btn_health)
        val btnOut = findViewById<Button>(R.id.btn_id_card2)

        btnId.setOnClickListener {
            startActivity(Intent(this, IDActivity::class.java))
        }
        btnMis.setOnClickListener {
            startActivity(Intent(this, TaskActivity::class.java))
        }
        btnHeal.setOnClickListener {
            startActivity(Intent(this, HealthActivity::class.java))
        }
        btnOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}