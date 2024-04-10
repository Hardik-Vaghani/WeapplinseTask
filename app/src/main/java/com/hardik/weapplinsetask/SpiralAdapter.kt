package com.hardik.weapplinsetask

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpiralAdapter():RecyclerView.Adapter<SpiralAdapter.MyViewHolder>() {
    private var items: MutableList<Int> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<Int>){
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    inner class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        private val textView = itemView.findViewById<TextView>(R.id.text)

        fun bind(item:String){
            textView.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rec,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(item = items[position].toString())
    }

    override fun getItemCount(): Int {
        return items.size
    }
}