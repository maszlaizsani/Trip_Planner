package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_planning.*
import java.text.SimpleDateFormat

class Planning : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning)

        val calendar=findViewById<CalendarView>(R.id.calendarView)
        val next=findViewById<Button>(R.id.next_plan)
        val getname=findViewById<EditText>(R.id.getname)

        //calendar.setOnDateChangeListener(){};
        next.setOnClickListener(){
            var startdate= SimpleDateFormat("dd/MM/yyyy").format(calendar.date)
            var tripname=getname.text
            Toast.makeText(applicationContext,"Saved "+startdate+" "+tripname,Toast.LENGTH_LONG).show()
        }

        val cancel=findViewById<ImageButton>(R.id.cancelplan)
        cancelplan.setOnClickListener(){
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

