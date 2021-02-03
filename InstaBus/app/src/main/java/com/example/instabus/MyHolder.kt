package com.example.instabus

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, StationDetailsActivity::class.java)
            itemView.context.startActivity(intent)
        }
    }
}
