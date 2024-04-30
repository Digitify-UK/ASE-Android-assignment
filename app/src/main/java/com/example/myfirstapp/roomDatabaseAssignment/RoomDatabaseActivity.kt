package com.example.myfirstapp.roomDatabaseAssignment

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R
import com.example.myfirstapp.roomDatabaseAssignment.database.Course
import com.example.myfirstapp.roomDatabaseAssignment.database.CourseDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomDatabaseActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var  courseDatabase: CourseDatabase
    private lateinit var btnAddCourse : FloatingActionButton
    private lateinit var btnFilterAllCourse : Button
    private lateinit var btnOrderByDurCourse : Button
    private lateinit var btnFilter30DurCourse : Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_room_database2)
        initViews()
        courseDatabase = CourseDatabase.getDBInstance(this)
        courseDatabase.courseDao().getCourseList().observe(this){

            initRecyclerView(it)
        }

        btnAddCourse.setOnClickListener {
        showDialog()
        }
        btnFilterAllCourse.setOnClickListener {
            courseDatabase.courseDao().getCourseList().observe(this){
                initRecyclerView(it)
            }
        }
        btnOrderByDurCourse.setOnClickListener {
            courseDatabase.courseDao().getASCCourseList().observe(this){
                initRecyclerView(it)
            }
        }
        btnFilter30DurCourse.setOnClickListener {
            courseDatabase.courseDao().getFilter30DurCourseList().observe(this){
                initRecyclerView(it)
            }
        }


    }
    private fun showDialog( ){
        val dialog= Dialog(this)
        dialog.setContentView(R.layout.add_course_dialog)
        val btnOK :Button = dialog.findViewById(R.id.btnAddCourseOk)
        val edtCourseName :EditText = dialog.findViewById(R.id.edtCourseName)
        val edtCourseDuration :EditText = dialog.findViewById(R.id.etdCourseDuration)
        val edtCourseTracks:EditText = dialog.findViewById(R.id.edtCourseTrack)
        val edtCourseDetails :EditText = dialog.findViewById(R.id.edtCourseDetails)
        dialog.show()

        btnOK.setOnClickListener {
            GlobalScope.launch {
                courseDatabase.courseDao().upsertCourse(
                    Course(
                        courseName = edtCourseName.text.toString(),
                        courseDuration = edtCourseDuration.text.toString(),
                        courseTrack = edtCourseTracks.text.toString(),
                        courseDescription = edtCourseDetails.text.toString()
                    )
                )

                dialog.dismiss()
            }
        }

    }

    private fun initViews(){
        recyclerview = findViewById(R.id.rvCourse)
        btnAddCourse= findViewById(R.id.btnFloatAddCourse)
        btnOrderByDurCourse =findViewById(R.id.btnOrderASC)
        btnFilterAllCourse = findViewById(R.id.btnFilterAll)
        btnFilter30DurCourse = findViewById(R.id.btnFilter30Dur)
    }
    private fun initRecyclerView(courses: List<Course>){
        this.recyclerview.layoutManager = LinearLayoutManager(this)
        val recyclerContactAdapter = RvCourseAdapter(this, courses)
        recyclerview.adapter = recyclerContactAdapter
    }


}