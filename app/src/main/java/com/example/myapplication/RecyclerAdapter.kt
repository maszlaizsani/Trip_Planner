package com.example.myapplication

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class RecyclerAdapter(myCtx: Context, val trips: ArrayList<Trip>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView = itemView.findViewById(R.id.itemtitle)
        var itemDest: TextView = itemView.findViewById(R.id.destinaton)
        var itemStart: TextView = itemView.findViewById(R.id.date)
        var itemEdit: ImageView= itemView.findViewById(R.id.editIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val trip: Trip=trips[position]
        holder.itemTitle.text=trip.tripNAME
        holder.itemDest.text="to " + trip.destination
        holder.itemStart.text= convertLongToTime(trip.tripStartDate)
    }

    override fun getItemCount(): Int {
    return trips.size
    }

    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd.MM.yyyy")
        return format.format(date)
    }
}