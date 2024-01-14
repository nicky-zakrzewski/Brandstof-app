package com.example.help

interface IGasStationRepository {
    fun getAllGasStations(): List<GasStation>
    fun getGasStationById(id: Int): GasStation?
    fun getGasStationsByCity(city: String): List<GasStation>
    fun getGasStationsByFuelType(fuelType: String): List<GasStation>
}