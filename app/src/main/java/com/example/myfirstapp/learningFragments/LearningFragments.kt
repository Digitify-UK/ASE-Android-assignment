package com.example.myfirstapp.learningFragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.myfirstapp.R

class LearningFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learnign_fragments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnFirstFrag : Button = findViewById(R.id.button)
        val btnSecond : Button = findViewById(R.id.button2)
        val btnThirdFrag : Button = findViewById(R.id.button4)
        loadFragment(Fragment1(),1)
        btnFirstFrag.setOnClickListener {
            loadFragment(Fragment1(),0)
        }
        btnSecond.setOnClickListener { loadFragment(Fragment2(),0) }
        btnThirdFrag.setOnClickListener {loadFragment(Fragment1(),0)  }

    }
    private fun loadFragment(fragment: Fragment, flag: Int){
         val fragTransaction : FragmentTransaction  = supportFragmentManager.beginTransaction()
        if(flag==1)
        fragTransaction.add(R.id.frameForFragments, fragment)
        else
            fragTransaction.replace(R.id.frameForFragments,fragment)

        fragTransaction.commit()

    }
}