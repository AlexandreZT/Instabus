/*
package com.example.instabus.retrofit.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instabus.R
import com.squareup.picasso.Picasso

import com.example.instabus.retrofit.models.Bus.Data.Tmb
class BusesAdapter(private val busesList: List<Tmb>) :RecyclerView.Adapter<BusesAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return busesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${busesList.size} ")
        return holder.bind(busesList[position])
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {

        var ivPicture = itemView.findViewById<ImageView>(R.id.ivPicture)
        var tvStreetName = itemView.findViewById<TextView>(R.id.tvStreetName)


        fun bind(bus: Tmb) {
            tvStreetName.text = bus.street_name
            Picasso.get().load(bus.picture).into(ivPicture)
        }
    }
}*/
