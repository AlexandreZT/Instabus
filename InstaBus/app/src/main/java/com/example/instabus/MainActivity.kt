package com.example.instabus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instabus.retrofit.helpers.BusesAdapter
import com.example.instabus.retrofit.models.Bus.Data.Tmb
import com.example.instabus.retrofit.services.BusService
import com.example.instabus.retrofit.services.ServiceBuilder
import okhttp3.Callback

import okhttp3.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
        loadBuses()
    }

    private fun loadBuses() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(BusService::class.java)
        val requestCall = destinationService.getBusList()
        //make network call asynchronously
        requestCall.enqueue(object: Callback<List<Tmb>> {
            override fun onResponse(call: Call<List<Tmb>>, response: Response<List<Tmb>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val busList  = response.body()!!
                    Log.d("Response", "buslist size : ${busList.size}")
                    //bus_recycler.apply {
                        //setHasFixedSize(true)
                        //layoutManager = GridLayoutManager(this@MainActivity,2)
                       // adapter = BusesAdapter(response.body()!!)
                    //}
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Tmb>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}