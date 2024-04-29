package com.example.myfirstapp.roomDatabaseImplementation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class RoomDatabaseActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    lateinit var productDatabase: ProductDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_room_database)
        val btnGetDbData: Button = findViewById(R.id.dbGetDataBtn)
        database = ContactDatabase.getDatabase(this)
        productDatabase = ProductDatabase.getDatabaseInstance(this)
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(id = 0, name = "Asif", Date()))
            productDatabase.productDAO().insertProduct(Product(0, "Nokia X2", R.drawable.person1, 40500.123))
        }
        database.contactDao().getContacts().observe(this, {
            Log.d("TAG125", it.toString())
        })

        btnGetDbData.setOnClickListener {
//            database.contactDao().getContacts().observe(this, {
//                Log.d("TAG125", it.toString())
//            })
            productDatabase.productDAO().getProductsList().observe(this, {
                Log.d("TAG125", it.toString())
            })
        }


    }
}