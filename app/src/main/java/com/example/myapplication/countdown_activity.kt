package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Spinner.MODE_DIALOG
import androidx.core.content.contentValuesOf
import myDBhelper
import java.util.*

class countdown_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown_layout)

    //-----------------------------------back button----------------------------------------
        val cancel=findViewById<ImageView>(R.id.cancelplan)
        cancel.setOnClickListener(){
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

     //-------------------------------Calculating remaining days-----------------------------
        var helper=myDBhelper(applicationContext)
        var db=helper.readableDatabase

        val qry= "SELECT * FROM TRIPS"
        val cursor=db.rawQuery(qry,null)
        cursor.moveToLast()
        var tripname=cursor.getString(1)
        var tripdate=cursor.getLong(3)

        val name=findViewById<TextView>(R.id.tripname)
        val daysremaining=findViewById<TextView>(R.id.counter)

        val currenttime : Long = Calendar.getInstance().timeInMillis
        val difference: Long = tripdate - currenttime
        val days = (((difference / 1000)/60)/60)/24

        name.text=tripname.toString()
        daysremaining.text=days.toString()

        cursor.close()
        db.close()

     //--------------------------------Settings---------------------------------------------
        val settings=findViewById<ImageView>(R.id.settingsButton)

        settings.setOnClickListener(){
            //TODO
        }
    }


    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd")
        return format.format(date)
    }
}