package com.example.recyclerviewadvanced

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide


class ContactDetailsFragment : Fragment() {

    private var contactNameDetails: String? = null
    private var contactImageDetails: String? = null
    private var contactSurnameDetails: String? = null
    private var contactNumberDetails: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            contactNameDetails = it.getString(CONTACT_NAME_ARG)
            contactImageDetails = it.getString(CONTACT_IMAGE_ARG)
            contactSurnameDetails = it.getString(CONTACT_SURNAME_ARG)
            contactNumberDetails = it.getString(CONTACT_NUMBER_ARG)

        }
    }

    private fun initView(view: View) {
        val tvContactNameDetails: TextView? = view.findViewById(R.id.tvNameDetails)
        val ivContactImageDetails: ImageView = view.findViewById(R.id.ivPhotoDetails)
        val tvContactSurnameDetails: TextView? = view.findViewById(R.id.tvSurnameDetails)
        val tvContactNumberDetails: TextView? = view.findViewById(R.id.tvNumberDetails)

        tvContactNameDetails?.text = contactNameDetails
        Glide.with(this).load(contactImageDetails).into(ivContactImageDetails)
        tvContactSurnameDetails?.text = contactSurnameDetails
        tvContactNumberDetails?.text = contactNumberDetails



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
    }


    companion object {
        private const val CONTACT_IMAGE_ARG = "contact_image_arg"
        private const val CONTACT_SURNAME_ARG = "contact_surname_arg"
        private const val CONTACT_NAME_ARG = "contact_name_arg"
        private const val CONTACT_NUMBER_ARG = "contact_number_arg"

        @JvmStatic
        fun newInstance(
            contactImage: String, contactSurname: String,
            contactName: String, contactNumber: String
        ) =
            ContactDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(CONTACT_IMAGE_ARG, contactImage)
                    putString(CONTACT_SURNAME_ARG, contactSurname)
                    putString(CONTACT_NAME_ARG, contactName)
                    putString(CONTACT_NUMBER_ARG, contactNumber)
                }
            }
    }
}