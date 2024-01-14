package com.example.help

data class GasStation(
    val id : Int,
    var name : String,
    var city : String,
    var address : String,
    var fuelPrices : MutableMap<String, Double>
)