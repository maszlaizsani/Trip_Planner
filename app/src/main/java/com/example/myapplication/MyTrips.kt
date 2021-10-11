package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import myDBhelper

class MyTrips : AppCompatActivity() {
    companion object {
        lateinit var mydbhelper: myDBhelper
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mytrips_layout)

        val cancel = findViewById<ImageView>(R.id.cancelplan)
        cancel.setOnClickListener() {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        mydbhelper=myDBhelper(this)
        viewPlans()
    }

     fun viewPlans(){
        val planList: ArrayList<Trip> = mydbhelper.getTrips(this)

        val rView=findViewById<RecyclerView>(R.id.recyclerview)
        rView.layoutManager=LinearLayoutManager(this, RecyclerView.VERTICAL,false) as RecyclerView.LayoutManager
        rView.adapter=RecyclerAdapter(this,planList)
    }
}