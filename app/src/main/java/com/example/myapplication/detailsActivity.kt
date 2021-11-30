package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.content.ContextCompat


class detailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //----------------------------Statusbar color change------------------------------------
        val window: Window = this@detailsActivity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ContextCompat.getColor(this@detailsActivity, R.color.statusbar)
        //#132e39

        //-----------------------------Back button----------------------------------------------

        val back=findViewById<ImageView>(R.id.backButton)

        back.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}