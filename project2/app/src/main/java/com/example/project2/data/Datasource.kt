package com.example.project2.data

import com.example.project2.R
import com.example.project2.model.GasStation

class Datasource {
    fun loadGasStations () : List<GasStation> {
        return listOf<GasStation>(
            GasStation(R.string.gasStation1),
            GasStation(R.string.gasStation2),
            GasStation(R.string.gasStation3),
            GasStation(R.string.gasStation4),
            GasStation(R.string.gasStation5),
            GasStation(R.string.gasStation6),
            GasStation(R.string.gasStation7),
            GasStation(R.string.gasStation8),

            )
    }
}