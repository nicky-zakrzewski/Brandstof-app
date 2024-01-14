package com.example.help

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GasStationAdapter(
    private val context: Context,
    private var gasStations: List<GasStation>
) : RecyclerView.Adapter<GasStationViewHolder>() {

    private var selectedFuelType: String = ""

    fun setSelectedFuelType(fuelType: String) {
        selectedFuelType = fuelType
        //notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GasStationViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return GasStationViewHolder(view)
    }

    override fun onBindViewHolder(holder: GasStationViewHolder, position: Int) {
        val gasStation = gasStations[position]

        //#REGION switch case image
        var image : Int
        when (gasStation.name) {
            "Shell" -> image = R.drawable.shell
            "Esso" -> image = R.drawable.esso
            "Gabriëls" -> image = R.drawable.gabriels
            "Gulf" -> image = R.drawable.gulf
            "Lukoil" -> image = R.drawable.lukoil
            "Q8" -> image = R.drawable.q8
            "Texaco" -> image = R.drawable.texaco
            "Total" -> image = R.drawable.total
            "Dats24" -> image = R.drawable.dats24
            else -> {
                image = R.drawable.missing
            }
        }
        //#ENDREGION

        holder.logoImageView.setImageResource(image)
        holder.nameTextView.text = gasStation.name

        // Toon de prijs van het geselecteerde brandstoftype
        val fuelPrice = gasStation.fuelPrices[selectedFuelType]
        holder.priceTextView.text = "€$fuelPrice"
    }

    override fun getItemCount(): Int {
        return gasStations.size
    }

    fun setData(newGasStations: List<GasStation>) {
        gasStations = newGasStations
        notifyDataSetChanged()
    }
}