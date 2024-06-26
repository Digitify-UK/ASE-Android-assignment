package com.example.myfirstapp.learningRecyclerviewAndAdapters

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R
import com.example.myfirstapp.sharedPreferences.SplashActivity

class LearningRecyclerviewAndAdaptersActivity : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var arrContact: ArrayList<ContactModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learning_recylcerview_and_adapters)

        initializeViews()
        initializeData()
        initializeRecyclerView()
        initializeButtons()
    }

    private fun initializeViews() {
        recyclerview = findViewById(R.id.recyclerView)
    }

    private fun initializeData() {
        arrContact = arrayListOf(
            ContactModel("Asif Imran", "03016691397", R.drawable.man1),
            ContactModel("Noor", "03016691397", R.drawable.woman3),
            ContactModel("Zaheer", "03426065866", R.drawable.man2),
            ContactModel("Hassan", "03476510029", R.drawable.man3),
                )
    }

    private fun initializeRecyclerView() {
        recyclerview.layoutManager = LinearLayoutManager(this)
        val recyclerContactAdapter = RecyclerviewContactAdapter(this, arrContact)
        recyclerview.adapter = recyclerContactAdapter
    }

    private fun initializeButtons() {
        val btnAddNew: Button = findViewById(R.id.btnAddItemToList)
        val btnDeleteListItem: Button = findViewById(R.id.btnDeleteListItem)
        val btnSortList: Button = findViewById(R.id.btnSortList)
        val btnLogout : Button = findViewById(R.id.btnLogout)

        btnAddNew.setOnClickListener { addNewItemToList() }
        btnSortList.setOnClickListener { sortList() }
        btnDeleteListItem.setOnClickListener { deleteListItem() }
        btnLogout.setOnClickListener {
            clearSharedPreference()
        }
    }
    private fun clearSharedPreference (){
        val sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE).edit()
        sharedPreferences.clear().apply()
        startActivity(Intent(this, SplashActivity::class.java))
       Log.d("Tag125","Logged out")
    }

    private fun addNewItemToList() {
        val random = kotlin.random.Random
        val randomNumber = random.nextInt(0, 3)
        arrContact.add(0, arrContact[randomNumber])
        recyclerview.adapter?.notifyItemInserted(0)
        showToast("New item added to list")
    }

        @SuppressLint("NotifyDataSetChanged")
        private fun sortList() {
        arrContact.sortBy { it.personName }
        recyclerview.adapter?.notifyDataSetChanged()
        showToast("List has been sorted")
    }


    private fun deleteListItem() {
        if (arrContact.isNotEmpty()) {
            arrContact.removeAt(0)
            recyclerview.adapter?.notifyItemRemoved(0)
            showToast("Item removed")
        } else {
            showToast("List is empty")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
