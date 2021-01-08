package com.example.instabus.retrofit.services

import com.example.instabus.retrofit.models.Bus.Data.Tmb
import retrofit2.Call
import retrofit2.http.GET

interface BusService {

    @GET("buses")
    fun getBusList () : Call<List<Tmb>>
}