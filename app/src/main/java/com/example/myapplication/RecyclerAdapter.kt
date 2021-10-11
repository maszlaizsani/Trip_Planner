package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(myCtx: Context, val trips: ArrayList<Trip>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemtitle: TextView
        var itemdest: TextView

        init{
            itemtitle=itemView.findViewById(R.id.itemtitle)
            itemdest=itemView.findViewById(R.id.destinaton)
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
    }

    override fun getItemCount(): Int {
    return trips.size
    }
}