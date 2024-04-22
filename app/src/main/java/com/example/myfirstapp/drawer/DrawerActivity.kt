package com.example.myfirstapp.drawer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myfirstapp.R

class DrawerActivity : AppCompatActivity() {
    private lateinit var topAppBar : androidx.appcompat.widget.Toolbar
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var drawerLayout : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drawer)
        topAppBar= findViewById(R.id.topAppBar)
        drawerLayout= findViewById(R.id.main)
       setupViews()
    }
    private  fun setupViews(){
        setUpDrawerLayout()
    }
    private fun setUpDrawerLayout(){
        setSupportActionBar(topAppBar)
        actionBarDrawerToggle= ActionBarDrawerToggle(this,drawerLayout, R.string.app_name, R.string.app_name)
    actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}