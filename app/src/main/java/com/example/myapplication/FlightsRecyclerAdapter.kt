package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class FlightsRecyclerAdapter(myCtx: Context, val items: List<String>): RecyclerView.Adapter<FlightsRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView = itemView.findViewById(R.id.itemname)
        //var addButton: TextView=itemView.findViewById(R.id.addToPlan)
        var itemImage: ImageView=itemView.findViewById(R.id.itemimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.flights_recycler_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text=items[position]
        val ctx=holder.itemTitle.context
        holder.itemImage.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.airplane))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}