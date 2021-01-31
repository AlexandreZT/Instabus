package com.example.instabus.retrofit.models

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.GET


interface StationAPI {
    @GET("/bus/nearstation/latlon/41.3985182/2.1917991/1.json")
    fun stationsList(): Call<StationResponse>
}

data class StationResponse (
        @Json(name = "code") var code: Int,
        @Json(name = "data") var data: NearStation
)

data class NearStation(
        @Json(name = "nearstations") var stations: List<Station>
)

data class Station(
        @Json(name = "id") var id: Long,
        @Json(name = "street_name") var streetName: String?,
        @Json(name = "city") var city: String?,
        @Json(name = "utm_x") var utmX: String?,
        @Json(name = "utm_y") var utmY: String?,
        @Json(name = "lat") var latitude: String?,
        @Json(name = "lon") var longitude: String?,
        @Json(name = "furniture") var furniture: String?,
        @Json(name = "buses") var buses: String?,
        @Json(name = "distance") var distance: Float,
)

/*data class Bus( // data class build with JSON To Kotlin plugin (original)
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
            val utm_y: String
        )
    }
}*/

/*data class Bus(
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
}*/
