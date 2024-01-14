package com.example.help

import GasStationViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GasStationViewModelFactory(private val repository: IGasStationRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GasStationViewModel::class.java)) {
            return GasStationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}


