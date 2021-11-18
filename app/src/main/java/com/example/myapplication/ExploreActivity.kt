package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explore_layout)

        showPlaces()
        showActivities()
        showFlights()

        //------------------------------------Back button-------------------------------------
        val cancel=findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    //---------------------------------Recommended places-------------------------------------

    private fun showPlaces() {
            val placeList = arrayOf("Paris", "Vancouver", "Budapest","Toronto","New York City","Stockholm","London")
            val rView = findViewById<RecyclerView>(R.id.placesRecycler)
            rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
            rView.adapter = CitiesRecyclerAdapter(this, placeList)
    }
    //-------------------------------Recommended activities----------------------------------

    private fun showActivities() {
        val activityList = arrayOf("Scubadiving", "Hiking", "Sightseeing","Cycling")
        val rView = findViewById<RecyclerView>(R.id.activitiesRecycler)
        rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
        rView.adapter = ActivitiesRecyclerAdapter(this, activityList)
    }
    //----------------------------------------Flights----------------------------------------

    private fun showFlights() {
        val flightList = arrayOf("Flight1", "Flight2", "Flight3","Flight4")
        val rView = findViewById<RecyclerView>(R.id.flightsRecycler)
        rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
        rView.adapter = FlightsRecyclerAdapter(this, flightList)
    }
}