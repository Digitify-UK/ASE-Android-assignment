package com.example.myfirstapp.sharedpreferences

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.R
import com.example.myfirstapp.learningRecyclerviewAndAdapters.LearningRecyclerviewAndAdaptersActivity

class SplashActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        val sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE)
        Handler(Looper.getMainLooper()).postDelayed({
            Log.d("Tag125", "Checking")
            val email = sharedPreferences.getString("Email",null)
            if (email!=null) {
                startActivity(Intent(this,LearningRecyclerviewAndAdaptersActivity::class.java))
            } else
            startActivity(Intent(this, LoginActivity::class.java))
        }, 4000)
    }
}
