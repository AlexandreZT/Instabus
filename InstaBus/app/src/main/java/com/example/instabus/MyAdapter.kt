package com.example.instabus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.instabus.retrofit.models.APIResponse
import com.example.instabus.retrofit.models.Station
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*
import kotlinx.android.synthetic.main.station_detail.view.*

// class Station(val stations: String, val imageUrl: String)

class MyAdapter(private val dataList: MutableList<Station>) : RecyclerView.Adapter<MyHolder>() { // private val listener: Any

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val streetNameTextView = holder.itemView.street_name_view
        // val stationPictureImgView = holder.itemView.station_picture
        val streetName = "${data.streetName} "
        streetNameTextView.text = streetName

        // holder.itemView.street_name_view.text = "${data.streetName}" // shortcut

        // à remettre plus tard
        /*Picasso.get()
            .load(data.picture)
            .into(stationPictureImgView)*/

        // lorsque je click sur le nom d'une ville
        /*holder.itemView.setOnClickListener {
            // j'aimerai aller dans les détails
           // listener(data)
            Toast.makeText(context, streetName, Toast.LENGTH_SHORT).show()
        }*/

    }
    /*class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val buses = itemView.findViewById<TextView>(R.id.buses)
        // private val image = itemView.findViewById<ImageView>(R.id.image)
        fun bind(item: Station) {
            buses.text = item.buses
            // image.loadUrl(item.imageUrl)
        }
    }*/
}