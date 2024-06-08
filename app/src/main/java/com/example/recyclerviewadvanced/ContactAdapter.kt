package com.example.recyclerviewadvanced

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ContactAdapter(val contactList: MutableList<Contacts>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val view =LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentContact = contactList[position]
        holder.contactImage.setImageResource(currentContact.photo)
        holder.tvName.text = currentContact.name
        holder.tvSurname.text = currentContact.surname
        holder.tvNumber.text = currentContact.phoneNumber.toString()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val contactImage: ImageView = view.findViewById(R.id.ivPhoto)
        val tvSurname: TextView = view.findViewById(R.id.tvSurname)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvNumber: TextView = view.findViewById(R.id.tvNumber)

    }
}