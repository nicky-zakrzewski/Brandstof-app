
import androidx.lifecycle.ViewModel
import com.example.help.GasStation
import com.example.help.IGasStationRepository

class GasStationViewModel(private val gasStationRepository: IGasStationRepository) : ViewModel() {

    fun getAllGasStations() = gasStationRepository.getAllGasStations()

    fun getGasStationsByFuelType(fuelType: String): List<GasStation> {
        var gasStations = getAllGasStations()
        return gasStations.filter { it.fuelPrices.containsKey(fuelType) }.toList().sortedBy { it.fuelPrices[fuelType] }
    }
    fun getGasStationsByFuelTypeAndCity(selectedFuelType: String, city: String): List<GasStation> {
        var gasStations = getAllGasStations()
        if (city.isEmpty()) {
            return getGasStationsByFuelType(selectedFuelType)
        }
        return gasStations.filter { gasStation ->
            gasStation.fuelPrices.containsKey(selectedFuelType) && gasStation.city.lowercase() == city.lowercase()
        }.toList().sortedBy { it.fuelPrices[selectedFuelType] }
    }
}

