package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class activity_planning2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning2)

        //---------------------------Back button---------------------------------
        val cancel=findViewById<ImageView>(R.id.cancelplan)
        cancel.setOnClickListener(){
            val intent = Intent(applicationContext, Planning::class.java)
            startActivity(intent)
        }

        //-------------------Dropdown list----------------------------------------
        val spinner1=findViewById<Spinner>(R.id.dropdownlist)
        val items= arrayOf("Hungary","Spain","USA","Canada","Mexico","China","Sweden","Austria","England")
        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(this, android.R.layout.simple_spinner_dropdown_item, items)
        spinner1.setAdapter(adapter)

        //-----------------------Add more destinations------------------------------
        //To do//
    }
}
