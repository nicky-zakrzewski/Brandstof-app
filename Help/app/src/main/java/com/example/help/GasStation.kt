package com.example.help

data class GasStation(
    val id: Int = 0,
    var name: String = "",
    var city: String = "",
    var address: String = "",
    var fuelPrices: MutableMap<String, Double> = mutableMapOf()
)