package com.example.myfirstapp.roomDatabaseAssignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Course::class], version = 1)
abstract class CourseDatabase :RoomDatabase() {
    abstract fun courseDao():CourseDao


    //implementing singleton approach to create instance of database using companion objects
    companion object{

        private var INSTANCE : CourseDatabase? = null

        fun getDBInstance (context: Context):CourseDatabase{
            if (INSTANCE ==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, CourseDatabase::class.java,"courseDB").build()
                }
            }
            return INSTANCE!!


        }

    }
}