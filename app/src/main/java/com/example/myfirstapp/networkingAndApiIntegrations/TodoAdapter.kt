package com.example.myfirstapp.networkingAndApiIntegrations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.ItemTodosBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner  class TodoViewHolder(val binding:ItemTodosBinding): RecyclerView.ViewHolder(binding.root){



    }
    private val diffCallBack = object : DiffUtil.ItemCallback<TodoModel>(){
        override fun areItemsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
            return oldItem.id== newItem.id;
        }

        override fun areContentsTheSame(oldItem: TodoModel, newItem: TodoModel): Boolean {
            return  oldItem == newItem
        }

    }
    private  val differ = AsyncListDiffer( this@TodoAdapter, diffCallBack)
    var todos : List<TodoModel>
        get()= differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
    return TodoViewHolder(
        ItemTodosBinding.inflate(
            LayoutInflater.from(
                parent.context,
            ), parent, false
        )

    )
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.binding.apply {

            tvTodoTitle.text = todo.title
            switchCompleted.isChecked =todo.completed
        }
    }


}