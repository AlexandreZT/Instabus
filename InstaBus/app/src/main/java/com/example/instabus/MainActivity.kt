package com.example.instabus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.example.instabus.retrofit.models.BarcelonaAPI
import com.example.instabus.retrofit.models.APIResponse
import com.example.instabus.retrofit.models.Station
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.station_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    private val dataList: MutableList<Station> = mutableListOf()
    private lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // view principal


        // ---------------------- BEGIN : Retrofit ----------------------
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

                // Setup Adapter
                myAdapter = MyAdapter(dataList, this@MainActivity) // manque un argument

                // Setup Recyclerview
                recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
                recycler_view.addItemDecoration(DividerItemDecoration(this@MainActivity, OrientationHelper.VERTICAL))
                recycler_view.adapter = myAdapter

                if (resp != null) {
                    dataList.addAll(resp.data.stations)
                }

                myAdapter.notifyDataSetChanged()

                // ----- en cours, gestion du stockage des images et leur chemin d'accès dans un fichier json local ----- //
                // val firstStation = resp?.data?.stations?.get(0) // pour la premier station
                /*if (firstStation != null) {
                    //  je peux modifier les champs
                    firstStation.urlPicture = "url de la photo"
                    firstStation.textPicture = "text de la photo"
                }*/

                /*val pic = Picture(1, "img.png", "nice picture")
                val jsonPicture = pic.uploadPicture()
                Log.d("JSON", jsonPicture)*/

                /*var gson = Gson()
                var jsonString = gson.toJson(Picture(1,"img.png", "description"))*/

                // ----- fin de test ----- //

                if (response.isSuccessful){ // if 200
                    if (resp != null) {
                        // loadPictures
                        for (station in resp.data.stations){
                            Log.d("API Callback","Found : $station")
                        }
                    }

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

    override fun onItemClick(item: Station, position: Int) {
        val clickedItem : Station = dataList[position]
        val intent = Intent(this, StationDetailsActivity::class.java)
        intent.putExtra("streetName", clickedItem.streetName)
        startActivity(intent)
    }
}