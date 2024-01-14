package com.example.help

class MockGasStationRepository : IGasStationRepository{

    private val gasStations = mutableListOf(
        GasStation(
            id = 1,
            name = "Lukoil",
            city = "Maasmechelen",
            address = "Rijksweg 121",
            fuelPrices = mutableMapOf("Euro95" to 1.501, "Diesel" to 1.303, "LPG" to 0.638)
        ),
        GasStation(
            id = 2,
            name = "Shell",
            city = "Maastricht",
            address = "Maastrichterweg 63",
            fuelPrices = mutableMapOf("Euro95" to 1.551, "Diesel" to 1.326, "Euro98" to 1.954)
        ),
        GasStation(
            id = 3,
            name = "Q8",
            city = "Diepenbeek",
            address = "Agoralaan 65",
            fuelPrices = mutableMapOf("Euro95" to 1.553, "Diesel" to 1.327, "Euro98" to 1.958, "CNG" to 0.882)
        ),
        GasStation(
            id = 4,
            name = "Total",
            city = "Diepenbeek",
            address = "Agoralaan 99",
            fuelPrices = mutableMapOf("Euro95" to 1.264, "Diesel" to 1.984, "Euro98" to 1.748, "CNG" to 0.956,"LPG" to 0.538)
        ),
        GasStation(
            id = 5,
            name = "Texaco",
            city = "Lanaken",
            address = "Europalaan 15",
            fuelPrices = mutableMapOf("Euro95" to 1.264, "Diesel" to 1.984)
        ),
    )
    /*
    override fun getAllGasStations(): List<GasStation> {
        return gasStations.toList()
    }

    override fun getGasStationById(id: Int): GasStation? {
        return gasStations.find { it.id == id }
    }


    override fun getGasStationsByCity(city: String): List<GasStation> {
        return gasStations.filter { it.city == city }.toList()
    }
    */
    override fun getGasStationsByFuelType(fuelType: String): List<GasStation> {
        return gasStations.filter { it.fuelPrices.containsKey(fuelType) }.toList()
    }
    override fun getGasStationsByFuelTypeAndCity(selectedFuelType: String, city: String): List<GasStation> {
        if (city.isEmpty()) {
            return getGasStationsByFuelType(selectedFuelType)
        }
        return gasStations.filter { gasStation ->
            gasStation.fuelPrices.containsKey(selectedFuelType) && gasStation.city == city
        }
    }
}