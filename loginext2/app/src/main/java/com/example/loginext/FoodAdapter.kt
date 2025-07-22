package com.example.loginext
import com.example.loginext.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val items: List<FoodItem>) : RecyclerView.Adapter<FoodAdapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.img)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val price = itemView.findViewById<TextView>(R.id.tv_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val it = items[position]
        holder.name.text = it.name
        holder.price.text = "$${it.price}"
        holder.img.setImageResource(it.imageRes)
    }

    override fun getItemCount() = items.size
}
