package com.example.myfirstapp.learningRecyclerviewAndAdapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.R


class RecyclerviewContactAdapter(
    private val context: Context,
    private val arrContact: ArrayList<ContactModel>
) : RecyclerView.Adapter<RecyclerviewContactAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val personImg: ImageView =  itemView.findViewById(R.id.imageViewPersonImg)
        val personName: TextView = itemView.findViewById(R.id.tvPersonName)
        val personContact: TextView = itemView.findViewById(R.id.tvContactNumber)
        val onViewClick : View = itemView


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personImg.setImageResource(arrContact[position].personImg)
        holder.personName.text = arrContact[position].personName
        holder.personContact.text = arrContact[position].contactNumber
        holder.onViewClick.setOnClickListener {
            this.showToast("Clicked on ${arrContact[position].personName}")
            showPersonInfoDialog(context,arrContact[position])
        }
    }

    private  fun showToast(message:String){
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT

        ).show()
    }
    private  fun showPersonInfoDialog(context: Context, contactModel: ContactModel){
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.person_info_dialog)
        val btnOkay : Button = dialog.findViewById(R.id.btnDialogClose)
        val imgViewPersonImg : ImageView = dialog.findViewById(R.id.imgViewDialogPersonImg)
        val tvPersonName: TextView = dialog.findViewById(R.id.tvDialogPersonName)
        val tvPersonContactNo : TextView = dialog.findViewById(R.id.tvDialogPersonContact)

        imgViewPersonImg.setImageResource(contactModel.personImg)
        tvPersonName.text= contactModel.personName
        tvPersonContactNo.text = contactModel.contactNumber

        dialog.show()
        btnOkay.setOnClickListener {
            dialog.dismiss()
        }
    }


}