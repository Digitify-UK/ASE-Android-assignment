package com.example.myfirstapp.roomDatabaseAssignment

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R
import com.example.myfirstapp.roomDatabaseAssignment.database.Course
import com.example.myfirstapp.roomDatabaseAssignment.database.CourseDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RvCourseAdapter(
    private val context: Context,
    private val courseList: List<Course>,

) : RecyclerView.Adapter<RvCourseAdapter.ViewHolder>() {

    inner  class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val courseId: TextView = itemView.findViewById(R.id.tvCourseID)
        val courseName: TextView = itemView.findViewById(R.id.tvCourseName)
        val courseDuration: TextView = itemView.findViewById(R.id.tvCourseDuration)
        val courseTracks: TextView = itemView.findViewById(R.id.tvCourseTrack)
        val courseDesc: TextView = itemView.findViewById(R.id.tvCourseDetails)
        val btnDeleteCourse : ImageButton = itemView.findViewById(R.id.btnDelete)
        val btnEditCourse : ImageButton = itemView.findViewById(R.id.btnEdit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.course_recyclerview_item,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        holder.courseId.text = courseList[index].id.toString()
        holder.courseName.text = courseList[index].courseName
        holder.courseDuration.text = courseList[index].courseDuration
        holder.courseTracks.text = courseList[index].courseTrack
        holder.courseDesc.text = courseList[index].courseDescription
        holder.btnDeleteCourse.setOnClickListener {
            deleteCourse(courseList[index])
        }
        holder.btnEditCourse.setOnClickListener{
            updateCourseDialog(courseList[index])
        }
    }
    private fun deleteCourse(course:Course){
        val database = CourseDatabase.getDBInstance(context)
        GlobalScope.launch {
            database.courseDao().deleteCourse(course)
//
        }

    }

    private fun updateCourseDialog(course: Course){
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.add_course_dialog)

        val edtCourseName : EditText= dialog.findViewById(R.id.edtCourseName)
        val edtCourseDuration : EditText = dialog.findViewById(R.id.etdCourseDuration)
        val edtCourseTracks: EditText = dialog.findViewById(R.id.edtCourseTrack)
        val edtCourseDetails : EditText = dialog.findViewById(R.id.edtCourseDetails)
        val btnOk : Button = dialog.findViewById(R.id.btnAddCourseOk)

        edtCourseName.setText(course.courseName)
        edtCourseDuration.setText(course.courseDuration)
        edtCourseTracks.setText(course.courseTrack)
        edtCourseDetails.setText(course.courseDescription)
        dialog.show()
        btnOk.setOnClickListener {
             val database = CourseDatabase.getDBInstance(context)
            Log.d("TAG130", "updated data ${edtCourseName.text.toString()}" )
            GlobalScope.launch {
                database.courseDao().updateCourse(
                    Course(
                        id = course.id  ,
                        courseName =  edtCourseName.text.toString(),
                        courseDuration =  edtCourseDuration.text.toString(),
                        courseTrack =  edtCourseTracks.text.toString(),
                        courseDescription = edtCourseDetails.text.toString(),
                    )

                )
                dialog.dismiss()
            }
        }


    }
}