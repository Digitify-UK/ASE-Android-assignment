package com.example.myfirstapp.bottomNavBar

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myfirstapp.R
import com.example.myfirstapp.learningFragments.Fragment1
import com.example.myfirstapp.learningFragments.Fragment2
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottom_nav_bar)
        val btView = findViewById<BottomNavigationView>(R.id.bottomNavigationBar)
            btView.setBackgroundColor(Color.TRANSPARENT)

        loadFrag(Fragment1())
        val menuItemId = R.menu.bottom_nav_menu_items
        val badge = btView.getOrCreateBadge(menuItemId)
        badge.isVisible = true
        badge.number=99

        btView.setOnItemSelectedListener {
            val id = it.itemId

            when(id){
                R.id.bNavHome -> {
                loadFrag(Fragment1())
                }
                R.id.bNavLike -> {
                    loadFrag(Fragment2())
                }
                R.id.bNavContacts -> {
                    loadFrag(Fragment1())
                }
                R.id.bNavProfile -> {
                    loadFrag(Fragment1())
                }
            }
             true
        }
    }
    private fun loadFrag(fragment: Fragment, flag:Boolean = false){
        val fm = supportFragmentManager.beginTransaction()
        if(flag)
        fm.add(R.id.bottomNavFragment, fragment)
        else fm.replace(R.id.bottomNavFragment, fragment)
        fm.commit()


    }
}