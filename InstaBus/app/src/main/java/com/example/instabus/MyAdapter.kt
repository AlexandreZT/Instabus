package com.example.instabus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instabus.retrofit.models.APIResponse
import com.example.instabus.retrofit.models.Station
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.station_detail.view.*
import kotlinx.android.synthetic.main.station_list.view.*
import retrofit2.Callback

// class Station(val stations: String, val imageUrl: String)

class MyAdapter(private val dataList: MutableList<Station>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MyHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.station_list, parent, false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val stationPictureImgView = holder.itemView.station_picture
        // Picasso.get().load(data.picture).into(stationPictureImgView)
        Picasso.get().load(R.drawable.instabuslogo).into(stationPictureImgView)

        val streetNameTextView = holder.itemView.street_name
        val streetName = "${data.streetName} "
        streetNameTextView.text = streetName
    }

    interface OnItemClickListener {
        fun onItemClick(item: Station, position: Int)
    }
}

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, StationDetailsActivity::class.java)
            itemView.context.startActivity(intent)
        }
    }
}