package com.example.instabus.retrofit.models

import com.google.gson.annotations.SerializedName

data class Bus(
    val code: Int,
    val `data`: Data
) {
    data class Data(
        val tmbs: List<Tmb>
    ) {
        data class Tmb(
            val buses: String,
            val city: String,
            val furniture: String,
            val id: String,
            val lat: String,
            val lon: String,
            val street_name: String,
            val utm_x: String,
            val utm_y: String,
            val picture: String
        ) {
            data class BusInfo(
                val picture: String,
                @SerializedName("_id")
                val id: Int
            )
        }
    }
}
