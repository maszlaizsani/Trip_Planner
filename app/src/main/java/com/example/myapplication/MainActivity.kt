package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //--------------------------Button IDs-------------------------------
        val startplan = findViewById<Button>(R.id.button_newtrip);
        val mytrips=findViewById<Button>(R.id.button_mytrips)

        //--------------------------New plan button--------------------------
        startplan.setOnClickListener() {
            val intent = Intent(applicationContext, activity_planning::class.java)
            startActivity(intent)
        }
        //-------------------------------------------------------------------
        mytrips.setOnClickListener(){
            val intent = Intent(applicationContext, MyTrips::class.java)
            startActivity(intent)
        }
    }
}