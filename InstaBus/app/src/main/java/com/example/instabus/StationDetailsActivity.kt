package com.example.instabus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class StationDetailsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.station_detail) // lorsque l'activité est appellé, on change de view
    }
}