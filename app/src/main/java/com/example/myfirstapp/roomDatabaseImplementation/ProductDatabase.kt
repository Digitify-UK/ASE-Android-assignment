package com.example.myfirstapp.roomDatabaseImplementation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract  fun productDAO(): ProductDAO

    companion object{
    @Volatile
    private var INSTANCE : ProductDatabase ? = null

    fun getDatabaseInstance (context: Context) : ProductDatabase{
        if(INSTANCE ==null){
            synchronized(
                this,
            ){
                INSTANCE = Room.databaseBuilder(context.applicationContext, ProductDatabase::class.java, "ProductDB").build()
            }
        }
        return INSTANCE!!
    }
    }
}