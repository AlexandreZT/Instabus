package com.example.instabus.retrofit.services

import com.example.instabus.retrofit.models.Bus
import retrofit2.Call
import retrofit2.http.GET

interface CountryService {

    @GET("buses")
    fun getBusList () : Call<List<Bus>>
}