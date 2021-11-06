package com.example.myapplication

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class RecyclerAdapter(myCtx: Context, val trips: ArrayList<Trip>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemtitle: TextView
        var itemdest: TextView
        var itemstart: TextView

        init{
            itemtitle=itemView.findViewById(R.id.itemtitle)
            itemdest=itemView.findViewById(R.id.destinaton)
            itemstart=itemView.findViewById(R.id.date)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val trip: Trip=trips[position]
        holder.itemtitle.text=trip.tripNAME
        holder.itemdest.text="to " + trip.destination
        holder.itemstart.text= convertLongToTime(trip.tripStartDate)
    }

    override fun getItemCount(): Int {
    return trips.size
    }

    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd.MM.yyyy")
        return format.format(date)
    }
}