package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_planning.*

class activity_planning2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planning2)

        val cancel=findViewById<ImageView>(R.id.cancelplan)
        cancel.setOnClickListener(){
            val intent = Intent(applicationContext, Planning::class.java)
            startActivity(intent)
        }
    }
}