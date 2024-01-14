package com.example.help

import GasStationViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.help.databinding.FragmentHomeBinding
import androidx.lifecycle.Observer

private var _binding: FragmentHomeBinding? = null
private val binding get() = _binding!!

class HomeFragment : Fragment() {
    private val fuelTypes = arrayOf("Euro95", "Euro98", "Diesel", "LPG", "CNG", "Red Diesel")
    private lateinit var gasStationAdapter: GasStationAdapter
    private lateinit var gasStations: List<GasStation>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* Tasklist code
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val repository = MockGasStationRepository() //geen idee of dit juist is

        val viewModelFactory = GasStationViewModelFactory(repository)
        var viewModel = ViewModelProvider(this, viewModelFactory).get(GasStationViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapterView = GasStationAdapter()
        binding.gasStations.adapter = adapter

        viewModel.gasStations.observe(viewLifecycleOwner, Observer{
            it?.let {
                adapter.dataSet = it
            }
        })
        return view
         */
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //#REGION Spinner
        val spinner: Spinner = view.findViewById(R.id.fuelTypeSpinner)
        val arrayAdapter =
            ArrayAdapter<String>(requireContext().applicationContext, android.R.layout.simple_spinner_dropdown_item, fuelTypes)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // On spinner item selection, update the displayed fuel type
                gasStationAdapter.setSelectedFuelType(fuelTypes[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext().applicationContext, "No fuel type selected", Toast.LENGTH_SHORT).show()
            }
        }
        //#ENDREGION Spinner

        //#REGION RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.gasStationsRecyclerView)

        // Initialize the adapter with an empty list
        gasStationAdapter = GasStationAdapter(requireContext(), emptyList())
        recyclerView.adapter = gasStationAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Setup Show Gas Stations Button
        val showGasStationsButton: Button = view.findViewById(R.id.searchGasStationsButton)
        showGasStationsButton.setOnClickListener {
            // Filter gas stations based on the selected fuel type and city
            val selectedFuelType = fuelTypes[spinner.selectedItemPosition]
            val city = view.findViewById<EditText>(R.id.searchEditText).text.toString()
            val repository = MockGasStationRepository()
            val viewModelFactory = GasStationViewModelFactory(repository)
            var viewModel = ViewModelProvider(this, viewModelFactory).get(GasStationViewModel::class.java)
            val filteredGasStations = viewModel.getGasStationsByFuelTypeAndCity(selectedFuelType,city)
            // Update gasStations list and refresh RecyclerView
            gasStations = filteredGasStations
            gasStationAdapter.setData(gasStations)
        }
        //#ENDREGION Recyclerview
    }
}



