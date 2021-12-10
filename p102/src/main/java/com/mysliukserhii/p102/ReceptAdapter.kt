package com.mysliukserhii.p102

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReceptAdapter(private val items:List<ReceptData>) : RecyclerView.Adapter<ReceptAdapter.ReceptViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceptViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recept,parent,false)
        return ReceptViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: ReceptViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount() = items.size



    inner class ReceptViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        private val imageFood = itemView.findViewById<ImageView>(R.id.imageFood)
        private val nameFood = itemView.findViewById<TextView>(R.id.nameFood)
        private val description = itemView.findViewById<TextView>(R.id.description)
        private val stars = itemView.findViewById<TextView>(R.id.stars)

        fun bind(receptData: ReceptData)
      {
          imageFood.setImageResource(receptData.imageFood)
          description.text = receptData.description
          nameFood.text = receptData.nameFood
          stars.text = receptData.stars
        }
    }
}