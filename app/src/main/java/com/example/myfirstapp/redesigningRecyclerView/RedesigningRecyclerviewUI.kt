package com.example.myfirstapp.redesigningRecyclerView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myfirstapp.R

class RedesigningRecyclerviewUI : AppCompatActivity() {
    private lateinit var contactsRecyclerview: RecyclerView
    private lateinit var contactsArrayList: ArrayList<ContactsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_redesigning_ui)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initializeViews()
        generateContacts()
        initializeRecyclerview()

    }

    private fun initializeViews() {
        contactsRecyclerview = findViewById(R.id.contactsRecyclerview)
    }

    private fun initializeRecyclerview() {
        this.contactsRecyclerview.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val contactsAdapter = ContactsAdapter(this, contactsArrayList)

        this.contactsRecyclerview.adapter = contactsAdapter
    }

    private fun generateContacts() {
        this.contactsArrayList = arrayListOf(
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),
            ContactsModel("David", "03016691397", img = R.drawable.person1),
            ContactsModel("Anila", "03426065866", img = R.drawable.person3),
            ContactsModel("Jack", "03016691397", img = R.drawable.person2),



        )
    }
}