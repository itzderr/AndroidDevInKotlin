package com.derrick.park.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_sw_list_item.view.*

interface OnSWClickListener {
    fun onClick(v: View, item: SWChar)
}

class SWAdapter(private val delegate: OnSWClickListener, private val swChars: Array<SWChar>) : RecyclerView.Adapter<SWAdapter.SWViewHolder>() {
    // inflates a layout and return the viewHolder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SWViewHolder {
        val itemView = LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.layout_sw_list_item, parent, false)
        return SWViewHolder(itemView)
    }

    // tells the recyclerView how many total items we have to display
    override fun getItemCount(): Int = swChars.size

    // binds data with viewHolder
    override fun onBindViewHolder(holder: SWViewHolder, position: Int) {
        holder.bind(swChars[position])
        holder.itemView.setOnClickListener { v ->
            delegate.onClick(v, swChars[position])
        }
    }

    // ViewHolder
    class SWViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.nameTextView
        private val dataTextView: TextView = itemView.dataTextView

        fun bind(item: SWChar) {
            nameTextView.text = item.name
            dataTextView.text = "Height: ${item.height}, Mass: ${item.mass}"
        }
    }
}