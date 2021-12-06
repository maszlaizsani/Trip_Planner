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
        showHotels()

        //------------------------------------Back button-------------------------------------
        val cancel=findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
        //------------------------Saving newly added activities in DB-------------------------

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
                ActivitiesClass("New York City", R.drawable.newyork),
                ActivitiesClass("Calgary", R.drawable.calgary)
            )
            val rView = findViewById<RecyclerView>(R.id.placesRecycler)
            rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
            rView.adapter = CitiesRecyclerAdapter(this, placeList)
    }
    //-------------------------------Recommended activities----------------------------------

    private fun showActivities() {
        val activityList = listOf(
            ActivitiesClass("Cycling", R.drawable.cycling),
            ActivitiesClass("Hiking", R.drawable.hiking),
            ActivitiesClass("Visit a Museum", R.drawable.museum),
            ActivitiesClass("Sightseeing", R.drawable.sightseeing),
            ActivitiesClass("Visit a zoo", R.drawable.zoo),
            ActivitiesClass("Dining out", R.drawable.restaurant),
            ActivitiesClass("Go camping", R.drawable.camping))

        val rView = findViewById<RecyclerView>(R.id.activitiesRecycler)
        rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
        rView.adapter = ActivitiesRecyclerAdapter(this, activityList)
    }
    //----------------------------------------Flights----------------------------------------

    private fun showHotels() {
        val hotelList = listOf("Hilton - Toronto", "Hotel Luxor - Cairo", "Boutique Hotel - Budapest","Le Narcisse Blanc Hotel - Paris")
        val rView = findViewById<RecyclerView>(R.id.hotelsRecycler)
        rView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) as RecyclerView.LayoutManager
        rView.adapter = HotelsRecyclerAdapter(this, hotelList)
    }

}