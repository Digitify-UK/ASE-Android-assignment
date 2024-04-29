package com.example.myfirstapp.roomDatabaseImplementation

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val pName: String,
    val pImage: Int,
    val pPrice: Double
)
