package com.example.myfirstapp.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.databinding.ActivityLoginBinding
import com.example.myfirstapp.learningRecyclerviewAndAdapters.LearningRecyclerviewAndAdaptersActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var loginModel: LoginModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
setContentView(binding.root)
val email = binding.edtEmail.text
val password = binding.edtPassword.text
val sharedPreferences =getSharedPreferences("Login",MODE_PRIVATE)
binding.btnLogin.setOnClickListener {
    sharedPreferences.edit().apply{
        putString("Email",email.toString())
    }.apply()
    Log.d("Tag125", "saved the data in shared prefs")
    startActivity(Intent(this, LearningRecyclerviewAndAdaptersActivity::class.java))
}

////

    }
}





