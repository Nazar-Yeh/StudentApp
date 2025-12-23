package com.example.studentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class TaskActivity : ComponentActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val db = Firebase.firestore
        val inp = findViewById<TextView>(R.id.inpL)
        val btnBack = findViewById<Button>(R.id.button2)
        val user = auth.currentUser

        if (user == null) {
            inp.text = "Помилка доступу. Користувач не знайдений."
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
            return
        }

        db.collection("deadlines")
            .document(user.uid)
            .get()
            .addOnSuccessListener { doc ->
                val title = doc.getString("title")
                val date = doc.getString("dueAt")
                val desc = doc.getString("desription")
                inp.text = "$title\n" + "Дедлайн: $date\n\n" + "Опис: $desc\n"
            }
        btnBack.setOnClickListener {
            finish()
        }
    }
}