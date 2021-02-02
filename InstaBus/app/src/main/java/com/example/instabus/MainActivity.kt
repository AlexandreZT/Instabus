package com.example.instabus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
// import com.example.instabus.retrofit.models.Bus
import com.example.instabus.retrofit.models.BarcelonaAPI
import com.example.instabus.retrofit.models.APIResponse
import com.example.instabus.retrofit.models.Picture
// import com.example.instabus.retrofit.services.BusService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
// import com.example.instabus.retrofit.services.ServiceBuilder
// import com.example.instabus.retrofit.helpers.BusesAdapter
import retrofit2.Retrofit
import kotlinx.android.synthetic.main.activity_main.*
// import kotlinx.android.synthetic.main.item_view.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // view principal
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        // Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()

        loadStations() // on récupère les données
        // loadBuses() // ancienne version (avec recycler view)

        val details = findViewById<Button>(R.id.details)

        details.setOnClickListener{
            val intent = Intent(this, StationDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadStations(){
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://barcelonaapi.marcpous.com")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

        val service = retrofit.create(BarcelonaAPI::class.java)
        val call = service.stationsList()

        call.enqueue(object : Callback<APIResponse> {
            override fun onResponse(
                    call: Call<APIResponse>,
                    response: Response<APIResponse>
            ) {
                val resp: APIResponse? = response.body()
                Log.d("API Callback", "Response: $resp")

                // val firstStation = resp?.data?.stations?.get(0) // pour la premier station
                /*if (firstStation != null) {
                    //  je peux modifier les champs
                    firstStation.urlPicture = "url de la photo"
                    firstStation.textPicture = "text de la photo"
                }*/

                val pic = Picture(1, "img.png", "nice picture")
                val jsonPicture = pic.uploadPicture()
                Log.d("JSON", jsonPicture)

                /*var gson = Gson()
                var jsonString = gson.toJson(Picture(1,"img.png", "description"))*/

                if (response.isSuccessful){ // if 200
                    if (resp != null) {
                        // loadPictures
                        for (station in resp.data.stations){
                            Log.d("API Callback","Found : $station")
                        }
                    }

                    // recycler view
                   /*bus_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                        adapter = BusesAdapter(response.body()!!)
                    }*/

                } else { // if != 200
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                    Log.d("STATUS", "${response.code()}")
                }

            }



            override fun onFailure(call: Call<APIResponse>?, t: Throwable) { // pas de réponse
                t.printStackTrace()
                    Log.e("API Callback", "Failure : $t")
            }
        })
    }

   /* private fun loadBuses() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(BusService::class.java)
        val requestCall = destinationService.getBusList()
        //make network call asynchronously
        requestCall.enqueue(object: Callback<List<Bus.Data.Tmb>> {
            override fun onResponse(call: Call<List<Bus.Data.Tmb>>, response: Response<List<Bus.Data.Tmb>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val busList  = response.body()!!
                    Log.d("Response", "buslist size : ${busList.size}")
                    bus_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity,2)
                       adapter = BusesAdapter(response.body()!!)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<Bus.Data.Tmb>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }*/
}