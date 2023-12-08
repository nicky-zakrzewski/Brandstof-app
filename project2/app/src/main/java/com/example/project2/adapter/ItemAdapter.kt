package com.example.project2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.R
import com.example.project2.model.GasStation

class ItemAdapter(
    private val context: Context,
    private val dataset: List<GasStation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //val textView: TextView = view.findViewById(R.id.item_title)
        val textView: TextView = view.findViewById(R.id.name)
        val cardView: CardView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        //holder.cardView.text = context.resources.getString(item.stringResourceId)
        //holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }
}