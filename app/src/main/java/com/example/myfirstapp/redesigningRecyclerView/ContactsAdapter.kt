package com.example.myfirstapp.redesigningRecyclerView

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R

class ContactsAdapter(val context: Context, val contactsArrayList : ArrayList<ContactsModel>):
RecyclerView.Adapter<ContactsAdapter.ViewHolder>()

{
        inner  class ViewHolder(itemViews : View) : RecyclerView.ViewHolder(itemViews){
         val imgViewPerson :ImageView = itemView.findViewById(R.id.imageViewPersonImageStaggered)
          val tvPersonName : TextView = itemViews.findViewById(R.id.tvPersonNameStaggered)
            val onItemViewClick: View= itemViews
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.contacts_staggered_grid_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvPersonName.text =contactsArrayList[position].name
        holder.imgViewPerson.setImageResource(contactsArrayList[position].img)
        holder.onItemViewClick.setOnClickListener {
            showImageOnFullScreen(contactsArrayList[position])
        }
    }

    override fun getItemCount(): Int {
       return contactsArrayList.size
    }

    private  fun showImageOnFullScreen( contactModel : ContactsModel){
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.staggered_view_dialog)
        val img :ImageView= dialog.findViewById(R.id.imagePreview)
        img.setImageResource(contactModel.img)
        dialog.show()

        dialog.setOnDismissListener {
            dialog.dismiss()
        }
    }


}