package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.countdown_layout.*
import myDBhelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ExploreActivity : AppCompatActivity() {
    companion object {
        lateinit var mydbhelper: myDBhelper
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explore_layout)

        mydbhelper =myDBhelper(this)
        showPlaces()
        showActivities()
        showFlights()

        //------------------------------------Back button-------------------------------------
        val cancel=findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
        //------------------------Saving newly added activities in DB-------------------------
        //Toast.makeText(this,"${adding.trip}, ${adding.city},${adding.activity}",Toast.LENGTH_SHORT).show()
        if(adding.trip!="" && adding.city!="" && adding.activity=="") {
                mydbhelper.saveCity(adding.city,adding.trip)
                adding.setDefault()
        }
        if(adding.trip!="" && adding.activity!="" && adding.city==""){
                mydbhelper.saveActivity(adding.activity,adding.trip)
                adding.setDefault()
        }

    }

    //---------------------------------Recommended places-------------------------------------

    private fun showPlaces() {
            val placeList = listOf(ActivitiesClass("Toronto", R.drawable.toronto),
                ActivitiesClass("Paris", R.drawable.paris),
                ActivitiesClass("Vancouver", R.drawable.vancouver),
                ActivitiesClass("Budapest", R.drawable.budapest),
                ActivitiesClass("Cairo", R.drawable.cairo),
                ActivitiesClass("New York City", R.drawable.newyork)
            )
            val rView = findViewById<RecyclerView>(R.id.placesRecycler)
            rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
            rView.adapter = CitiesRecyclerAdapter(this, placeList)
    }
    //-------------------------------Recommended activities----------------------------------

    private fun showActivities() {
        val activityList = listOf(
            ActivitiesClass("Go cycling", R.drawable.cycling),
            ActivitiesClass("Go hiking", R.drawable.hiking),
            ActivitiesClass("Visit a Museum", R.drawable.museum),
            ActivitiesClass("Go sightseeing", R.drawable.sightseeing),
            ActivitiesClass("Visit a zoo", R.drawable.zoo),
            ActivitiesClass("Try a new restaurant", R.drawable.restaurant))

        val rView = findViewById<RecyclerView>(R.id.activitiesRecycler)
        rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
        rView.adapter = ActivitiesRecyclerAdapter(this, activityList)
    }
    //----------------------------------------Flights----------------------------------------

    private fun showFlights() {
        val flightList = listOf("BUD-JFK", "BUD-YYZ", "BUD-YHZ","BUD-YEG")
        val rView = findViewById<RecyclerView>(R.id.flightsRecycler)
        rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
        rView.adapter = FlightsRecyclerAdapter(this, flightList)
    }

}