package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Spinner.MODE_DIALOG
import myDBhelper

class countdown_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown_layout)

        val cancel=findViewById<ImageView>(R.id.cancelplan)
        cancel.setOnClickListener(){
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        var helper= myDBhelper(applicationContext)
        var db=helper.readableDatabase


    }
}