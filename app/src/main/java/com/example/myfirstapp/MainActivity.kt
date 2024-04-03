package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val learning = Learning();
        learning.display();
        setContentView(R.layout.activity_login)
        val edtPassword : EditText= findViewById(R.id.edtPassword)
        val edtEmail : EditText = findViewById(R.id.edtEmail)


        val btnLogin:Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            Toast.makeText(this, "${edtEmail.text} has logged in",Toast.LENGTH_LONG).show()
        }
    }
}