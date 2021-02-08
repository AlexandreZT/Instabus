package com.example.instabus

import android.content.Intent.getIntent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.instabus.retrofit.models.Station
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.station_detail.*
import kotlinx.android.synthetic.main.station_list.*
import kotlinx.android.synthetic.main.station_list.view.*
import kotlinx.android.synthetic.main.station_list.view.station_picture
import kotlinx.android.synthetic.main.station_detail.view.*
// import kotlinx.android.synthetic.main.station_detail.view.*

class StationDetailsActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // station_detail / activity_main

        // streetName.text = intent.getStringExtra("streetName")
        // buses.text = intent.getStringExtra("buses")

        // Setup Recyclerview
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        recycler_view.adapter = StationDetailsAdapter() // listener

        // private val listener: AdapterView.OnItemClickListener
    }
    private class StationDetailsAdapter(): RecyclerView.Adapter<DetailsHolder>() {

        override fun getItemCount(): Int {
            return 1
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val customView = layoutInflater.inflate(R.layout.station_detail, parent, false)

            return DetailsHolder(customView)
        }

        override fun onBindViewHolder(holder: DetailsHolder, position: Int) {
            val stationPictureImgView = holder.itemView.stationPicture
            // Picasso.get().load(data.picture).into(stationPictureImgView)
            Picasso.get().load(R.drawable.instabuslogo).into(stationPictureImgView)

            val busesTextView = holder.itemView.buses
            //val buses = "${data.buses} "
            busesTextView.text = "buses" // buses

            val streetNameTextView = holder.itemView.streetName
            //val buses = "${data.streetName} "
            streetNameTextView.text = "streetName" // streetName

        }

    }

    private class DetailsHolder(val customView: View): RecyclerView.ViewHolder(customView) {

    }

}