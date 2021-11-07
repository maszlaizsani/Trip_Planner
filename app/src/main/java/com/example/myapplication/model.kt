package com.example.myapplication

import android.icu.text.SimpleDateFormat
import java.util.*

public class Trip {
   public var tripID: Int = 0
    public var tripNAME: String = ""
    public var destination: String = ""
    public var tripStartDate: Long = 0
    public var tripEndDate: Long = 0

    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd.MM.yyyy")
        return format.format(date)
    }
}