package com.example.instabus.retrofit.models
import com.squareup.moshi.Json
import retrofit2.Call
import retrofit2.http.GET


interface BarcelonaAPI {
    @GET(" /bus/stations.json")
    fun stationsList(): Call<APIResponse>
}

data class APIResponse (
        @Json(name = "code") var code: Int,
        @Json(name = "data") var data: Tmb
)

data class Tmb(
        @Json(name = "tmbs") var stations: List<Station>
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
)
// Il faudra ajouter un champs picture: String, pour stocker l'url vers les photos upload