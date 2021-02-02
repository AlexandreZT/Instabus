package com.example.instabus

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.instabus.retrofit.models.APIResponse
import com.example.instabus.retrofit.models.Station
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(private val dataList: MutableList<Station>) : RecyclerView.Adapter<MyHolder>() {

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

        // à remettre plus tard
        /*Picasso.get()
            .load(data.picture)
            .into(stationPictureImgView)*/

        // inutile mais peut-être qu'on mettra le on click vers les détails
        /*holder.itemView.setOnClickListener {
            Toast.makeText(context, streetName, Toast.LENGTH_SHORT).show()
        }*/
    }
}