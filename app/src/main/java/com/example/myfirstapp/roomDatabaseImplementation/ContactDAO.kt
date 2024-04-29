package com.example.myfirstapp.roomDatabaseImplementation

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
 interface  ContactDAO {
     @Insert
     suspend fun insertContact(contact:Contact)

     @Update
    suspend fun updateContact(contact:Contact)

     @Delete
     suspend fun deleteContact(contact:Contact)

     @Query ("Select * from contact")
     fun getContacts(): LiveData<List<Contact>>
}