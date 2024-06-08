package com.example.recyclerviewadvanced

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentList : Fragment() {

    private lateinit var contactImage: Array<Int>
    private lateinit var contactName: Array<String>
    private lateinit var contactSurname: Array<String>
    private lateinit var contactNumber: Array<String>

    private lateinit var newContactList: MutableList<Contacts>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager


        recyclerView.adapter = ContactAdapter(newContactList)






    }

    private fun dataInitialize() {

        newContactList = mutableListOf()
        contactImage = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d
        )
        contactName = arrayOf(
            "Kolya",
            "Petya",
            "Vasya",
            "Kiryuha"
        )
        contactSurname = arrayOf(
            "Petrov",
            "Ivanov",
            "Sidorov",
            "Ivashenko"
        )
        contactNumber = arrayOf(
            "89191689302",
            "89234578320",
            "89292930382",
            "89293740234"
        )

        for (i in contactImage.indices) {

            val contacts = Contacts(
                contactNumber[i].toString(), contactName[i],
                contactSurname[i],
                contactImage[i]
            )
            newContactList.add(contacts)

        }



    }
}

