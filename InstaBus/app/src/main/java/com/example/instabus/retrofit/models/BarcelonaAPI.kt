package com.example.instabus.retrofit.models
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
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

data class Station (
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

/*data class Picture(
        //var urlPicture: String,
        //var textPicture: String
        @SerializedName(value = "id") var id: Long,
        @SerializedName(value = "url_picture") var urlPicture: String,
        @SerializedName(value = "text_picture") var textPicture: String
)*/

class Picture(
        val id: Long,
        val filename: String,
        val description: String
) {
    // upload des photo (add picture : write)
    fun uploadPicture(): String {
        return """{"id": ${this.id}, "URL": "res/images/${this.filename}", "description": "${this.description}"}"""
    }

    // afficher les données
    fun readPicture():String{
        return "readPicture"
    }

    // supprimer une photo
    fun delPicture(){

    }
}