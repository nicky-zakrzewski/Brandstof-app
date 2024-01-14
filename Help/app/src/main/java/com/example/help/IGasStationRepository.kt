package com.example.help

interface IGasStationRepository {
    fun getAllGasStations() : List<GasStation>
    //fun getGasStationsByFuelType(fuelType: String): List<GasStation>
    //fun getGasStationsByFuelTypeAndCity(selectedFuelType: String, city: String): List<GasStation>
}