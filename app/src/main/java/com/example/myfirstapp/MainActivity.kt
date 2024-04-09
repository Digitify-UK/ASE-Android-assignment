package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.user_input_handling)
        var edtUserName:EditText= findViewById(R.id.edtUserNameField)
        var tvLuckyNumber: TextView = findViewById(R.id.tvLuckyNumber)
        var tvuserName: TextView = findViewById(R.id.tvUserName)
        val btnGenrateLuckyNumber= findViewById<Button>( R.id.btnGenerateLuckyNumber)
        btnGenrateLuckyNumber.setOnClickListener{
            var randomLuckyNumber= genrateRandomLuckyNumber()
            tvLuckyNumber.setText("${randomLuckyNumber}")
            tvuserName.setText("Hey! "+edtUserName.text)
        }

    }

    fun genrateRandomLuckyNumber():Int{
        val randomNumber = Random.nextInt(1000)
        return randomNumber
    }
}