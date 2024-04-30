package com.example.myfirstapp.roomDatabaseImplementation

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name:String,
    val data:Date
)
