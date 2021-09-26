package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_planning.*
import java.text.SimpleDateFormat

class Planning : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning)

        //------------------------Widget IDs------------------------------------
        val calendar=findViewById<CalendarView>(R.id.calendarView)
        val next=findViewById<Button>(R.id.next_plan)
        val getname=findViewById<EditText>(R.id.getname)
        val cancel=findViewById<ImageView>(R.id.cancelplan)

        //-------------------------Next button----------------------------------
        next.setOnClickListener(){
            var startdate= SimpleDateFormat("dd/MM/yyyy").format(calendar.date)
            val tripname=getname.text

            if (tripname.length>3) {
                Toast.makeText(applicationContext, "Saved " + startdate + " " + tripname, Toast.LENGTH_LONG).show()

                val intent = Intent(applicationContext, activity_planning2::class.java)
                startActivity(intent)
            }
            else Toast.makeText(applicationContext, "Trip name too short!",Toast.LENGTH_SHORT).show()
        }

        //---------------------------Back button----------------------------------
        cancel.setOnClickListener(){
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

