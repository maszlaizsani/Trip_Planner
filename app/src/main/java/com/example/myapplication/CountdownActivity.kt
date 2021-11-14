package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.*
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.list.customListAdapter
import myDBhelper
import java.util.*

class CountdownActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown_layout)

        //-----------------------------------Back button----------------------------------------
        val cancel=findViewById<ImageView>(R.id.cancelPlan)
        cancel.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        //-------------------------------Calculating remaining days-----------------------------

        val helper=myDBhelper(applicationContext)
        val db=helper.readableDatabase
        val name=findViewById<TextView>(R.id.tripname)
        val daysRemaining=findViewById<TextView>(R.id.counter)
        val days=findViewById<TextView>(R.id.days)


        val qry= "SELECT * FROM TRIPS"
        val cursor=db.rawQuery(qry,null)

        if (cursor.count!=0){
            cursor.moveToLast()
            val tripName=cursor.getString(1)
            val tripDate=cursor.getLong(3)
            val currentTime : Long = Calendar.getInstance().timeInMillis
            val difference: Long = tripDate - currentTime
            val days = (((difference / 1000)/60)/60)/24

            name.text=tripName.toString()
            daysRemaining.text=days.toString()
        }

        else {
            days.visibility=INVISIBLE
            daysRemaining.visibility= INVISIBLE
            name.text="No record yet"
        }

        cursor.close()
        db.close()

     //--------------------------------Settings---------------------------------------------
        val settings=findViewById<ImageView>(R.id.settingsButton)

        settings.setOnClickListener {
          //TODO
        }
    }
}