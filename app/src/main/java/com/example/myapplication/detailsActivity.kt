package com.example.myapplication

import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import myDBhelper
import java.util.*


class detailsActivity : AppCompatActivity() {

    companion object {
        lateinit var mydbhelper: myDBhelper
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        mydbhelper =myDBhelper(this)

        //----------------------------StatusBar color change------------------------------------

        val window: Window = this@detailsActivity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this@detailsActivity, R.color.detail_statusbar)
        //#132e39

        //-----------------------------Back button----------------------------------------------

        val back=findViewById<ImageView>(R.id.backButton)

        back.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        //--------------------------Getting attributes from DB----------------------------------

        val s: String = intent.getStringExtra("name").toString()
        val plan: Trip = mydbhelper.getTripDetails(this,s)

        val tripName=findViewById<TextView>(R.id.title)
        val date=findViewById<TextView>(R.id.date)
        val note=findViewById<TextView>(R.id.notes)
        val destinations=findViewById<TextView>(R.id.countries)

        tripName.text=plan.tripNAME
        date.text= convertLongToTime(plan.tripStartDate)
        note.text=plan.tripNote
        destinations.text=plan.destinations

    }
    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd.MM.yyyy")
        return format.format(date)
    }
}