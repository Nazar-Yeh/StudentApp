package com.example.studentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class IDActivity : ComponentActivity() {

    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val inp = findViewById<TextView>(R.id.about)
        val btnBack = findViewById<Button>(R.id.button2)
        val user = auth.currentUser
        if (user == null) {
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
            return
        }
        val uid = user.uid
        val db = Firebase.firestore

        db.collection("users")
            .document(uid)
            .get()
            .addOnSuccessListener { doc ->
                val name = doc.getString("name ")
                val email = doc.getString("email")
                val group = doc.getString("group")
                val spec = doc.getString("spec")
                val ticket = doc.getString("studentNum")
                val about = doc.getString("about")

                inp.text = "Імʼя: $name\n" + "Email: $email\n" + "Група: $group\n" + "Спец.: $spec\n" + "Квиток: $ticket\n\n" + about
            }
        btnBack.setOnClickListener {
            finish()
        }
    }
}
