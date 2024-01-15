package com.example.help

import com.google.firebase.database.*

class GasStationRepository : IGasStationRepository {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference.child("GasStations")
    private var gasStations = mutableListOf<GasStation>()

    init {
        loadGasStations()
    }

    private fun loadGasStations() {
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                gasStations.clear()
                for (gasStationSnapshot in snapshot.children) {
                    val gasStation = gasStationSnapshot.getValue(GasStation::class.java)
                    gasStation?.let {
                        gasStations.add(it)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Behandel annulering of fouten hier
            }
        })
    }
    override fun getAllGasStations(): List<GasStation> {
        return gasStations
    }
}