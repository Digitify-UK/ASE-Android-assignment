package com.example.myfirstapp.roomDatabaseAssignment.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface CourseDao {

    @Upsert
    suspend fun upsertCourse(course:Course)

    @Delete
    suspend fun  deleteCourse(course: Course)

    @Update
    suspend fun updateCourse(course: Course)

    @Query("SELECT * FROM course")
    fun  getCourseList(): LiveData<List<Course>>

    @Query("SELECT * FROM course where courseDuration =  '20 Days' ")
    fun  getFilter20DurCourseList(): LiveData<List<Course>>

    @Query("SELECT * FROM course Order by courseName ASC")
    fun  getASCCourseList(): LiveData<List<Course>>

    @Query("SELECT * FROM course where courseDuration =  '30 Days' ")
    fun  getFilter30DurCourseList(): LiveData<List<Course>>
}