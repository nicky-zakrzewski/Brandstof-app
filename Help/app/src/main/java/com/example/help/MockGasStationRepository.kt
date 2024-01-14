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
            fuelPrices = mutableMapOf("Euro95" to 1.774, "Diesel" to 1.984, "Euro98" to 1.748, "CNG" to 0.956,"LPG" to 0.538, "Red Diesel" to 1.452)
        ),
        GasStation(
            id = 5,
            name = "Texaco",
            city = "Lanaken",
            address = "Europalaan 15",
            fuelPrices = mutableMapOf("Euro95" to 1.264, "Diesel" to 1.984)
        ),
        GasStation(
            id = 6,
            name = "Dats24",
            city = "Opgrimbie",
            address = "Sint Martinus straat 75",
            fuelPrices = mutableMapOf("CNG" to 0.879, "LPG" to 0.511)
        ),
        GasStation(
            id = 7,
            name = "Esso",
            city = "Smeermaas",
            address = "Drukstraat 15",
            fuelPrices = mutableMapOf("Euro95" to 1.964, "Diesel" to 1.984, "LPG" to 0.631)
        ),
        GasStation(
            id = 8,
            name = "Gabriëls",
            city = "Rekem",
            address = "Steenweg 215",
            fuelPrices = mutableMapOf("Euro95" to 1.684, "Diesel" to 1.984, "Red Diesel" to 1.456)
        ),
        GasStation(
            id = 9,
            name = "Gulf",
            city = "Kotem",
            address = "Hegstraat 23a",
            fuelPrices = mutableMapOf("Euro95" to 1.387, "Diesel" to 1.984, "Red Diesel" to 1.341)
        ),
        GasStation(
            id = 10,
            name = "Bp",
            city = "Genk",
            address = "Stationstraat 5",
            fuelPrices = mutableMapOf("Euro95" to 1.984, "Diesel" to 2.058, "Euro98" to 2.145)
        ),

    )
    override fun getAllGasStations(): List<GasStation> {
        return gasStations;
    }
}