package com.example.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    val fuelTypes = arrayOf("Euro95","Euro98","Diesel","LPG","CNG", "Red Diesel")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)



        return view
    }

    //poging spinner
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner : Spinner = view.findViewById(R.id.fuelTypeSpinner)
        val arrayAdapter = ArrayAdapter<String>(requireContext().applicationContext, android.R.layout.simple_spinner_dropdown_item)
    }

    //einde poging spinner


}