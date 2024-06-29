package com.example.recyclerviewadvanced

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ContactAdapter(private val contactList: MutableList<Contacts>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentContact = contactList.get(holder.adapterPosition)
        holder.tvName.text = currentContact.name
        holder.tvSurname.text = currentContact.surname
        holder.tvNumber.text = currentContact.phoneNumber
        Glide.with(holder.itemView.context).load(currentContact.photo).into(holder.contactImage)
    }

    inner class ViewHolder(view: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val contactImage: ImageView = view.findViewById(R.id.ivPhoto)
        val tvSurname: TextView = view.findViewById(R.id.tvSurname)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvNumber: TextView = view.findViewById(R.id.tvNumber)

        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)
            }
        }
    }
}