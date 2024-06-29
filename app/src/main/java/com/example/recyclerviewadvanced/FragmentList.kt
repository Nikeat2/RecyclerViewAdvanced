package com.example.recyclerviewadvanced

import android.content.Context
import android.icu.text.Transliterator.Position
import android.media.RouteListingPreference.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class FragmentList : Fragment() {

    private lateinit var contactImage: Array<String>
    private lateinit var contactName: Array<String>
    private lateinit var contactSurname: Array<String>
    private lateinit var contactNumber: Array<String>
    private lateinit var newContactList: MutableList<Contacts>
    private lateinit var adapter: ContactAdapter

    private lateinit var fragmentDetails: ContactDetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataInitialize()

        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ContactAdapter(newContactList)



        val layoutManager = LinearLayoutManager(context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


        adapter.setOnItemClickListener(object : ContactAdapter.onItemClickListener{
            override fun onClick(position: Int) {

                val contactImage = newContactList[position].photo
                val contactName = newContactList[position].name
                val contactNumber = newContactList[position].phoneNumber
                val contactSurname = newContactList[position].surname

                goToDetailsFragment(
                    contactImage = contactImage,
                    contactName = contactName,
                    contactNumber = contactNumber ,
                    contactSurname = contactSurname
                )
            }
            })

        }




    private fun dataInitialize() {
        newContactList = mutableListOf<Contacts>()


        val contact1 = Contacts("Petya", "Ivanov", "89191689202",
            "https://content.api.news/v3/images/bin/9ad43a263d501ec015ac6ab4868edf25")

        val contact2 = Contacts( "Vasya", "Ivanov", "89192223331",
            "https://www.befunky.com/images/prismic/5ddfea42-7377-4bef-9ac4-f3bd407d52ab_landing-photo-to-cartoon-img5.jpeg?auto=avif,webp&format=jpg&width=863" )
        val contact3 = Contacts("Anton", "Petrov", "89103245982", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShBJIEXRlPyClttjiGNnTAQeFnKwl2Yv0oig&s")


        newContactList.add(0, contact1)
        newContactList.add(1, contact2)
        newContactList.add(contact3)




    }



    private fun goToDetailsFragment(
        contactImage: String, contactSurname: String,
        contactName: String, contactNumber: String
    ) {

        fragmentDetails = ContactDetailsFragment.newInstance(
            contactImage = contactImage,
            contactName = contactName,
            contactNumber = contactNumber,
            contactSurname = contactSurname
        )
        parentFragmentManager
            .beginTransaction().add(R.id.containerHome, fragmentDetails)
            .addToBackStack("ContactDetailsFragment.TAG")
            .commit()
    }

}


