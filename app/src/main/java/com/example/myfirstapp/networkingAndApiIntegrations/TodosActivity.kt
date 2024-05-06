package com.example.myfirstapp.networkingAndApiIntegrations

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityTodosBinding
import kotlinx.coroutines.launch

class TodosActivity : AppCompatActivity() {
    private  lateinit var todosBinding: ActivityTodosBinding
    private  lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        todosBinding = DataBindingUtil.setContentView(this,R.layout.activity_todos)
        setContentView(todosBinding.root)
        setupRecycler()
        lifecycleScope.launch {
            todosBinding.progressBar.isVisible = true
            val response = RetrofitInstance.api.getTodosRequest()
            if(response.isSuccessful && response.body()!=null){
                todosBinding.progressBar.isVisible=false
                todoAdapter.todos= response.body()!!
            }else{
                Log.e("TAG125","Response is not successfully")
            }
        }



    }
    private fun setupRecycler()= todosBinding.rvTodos.apply {
        todoAdapter= TodoAdapter()
        adapter=todoAdapter
        layoutManager= LinearLayoutManager(this@TodosActivity)
    }
}