package com.example.myapplication

import android.icu.text.SimpleDateFormat
import java.util.*

public class Trip {
    var tripID: Int = 0
    var tripNAME: String = ""
    var destinations: String = ""
    var tripStartDate: Long = 0
    var tripEndDate: Long = 0
    var tripNote: String=""
    var categories: String=""
    var activities: String=""
    var cities: String=""
}

public class Adding {
     var activity: String=""
    var trip: String=""
    var city: String=""
    fun setDefault(){
        trip=""
        city=""
        activity=""
    }
}
val adding=Adding()

