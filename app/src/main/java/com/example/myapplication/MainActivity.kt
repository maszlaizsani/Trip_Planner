package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import myDBhelper


class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var mydbhelper: myDBhelper
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActivity.mydbhelper =myDBhelper(this)
        viewPlans()

        //--------------------------Button IDs-------------------------------
        val startplan = findViewById<ImageView>(R.id.button_newtrip)
        val explore=findViewById<ImageView>(R.id.explore_button)
        val countdown=findViewById<ImageView>(R.id.button_countdown)

        //--------------------------New plan button--------------------------
        startplan.setOnClickListener() {
            val intent = Intent(applicationContext, activity_planning::class.java)
            startActivity(intent)
        }
        //--------------------------Countdown button--------------------------
        countdown.setOnClickListener(){
            val intent = Intent(applicationContext, countdown_activity::class.java)
            startActivity(intent)
        }
    }

    fun viewPlans(){
        val planList: ArrayList<Trip> = MainActivity.mydbhelper.getTrips(this)

        val rView=findViewById<RecyclerView>(R.id.recycler)
        rView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false) as RecyclerView.LayoutManager
        rView.adapter=RecyclerAdapter(this,planList)
    }
}