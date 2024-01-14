package com.example.help

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GasStationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val logoImageView: ImageView = itemView.findViewById(R.id.gasStationLogoImageView)
    val nameTextView: TextView = itemView.findViewById(R.id.gasStationNameTextView)
    val priceTextView: TextView = itemView.findViewById(R.id.fuelPriceTextView)
}