package com.example.myfirstapp.roomDatabaseAssignment.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("course")
data class Course(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0,
    val  courseName : String,
    val courseDuration : String,
    val courseTrack:String,
    val courseDescription: String
)
