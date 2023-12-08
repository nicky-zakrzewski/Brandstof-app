package com.example.project2.model

data class GasStation (val stringResourceId: Int){
    var name = "testnaam"
        get() = field
        set(value) {
            field = value
        }
}