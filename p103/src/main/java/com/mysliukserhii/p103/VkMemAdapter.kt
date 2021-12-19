package com.mysliukserhii.p103

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VkMemAdapter (private val items:List<VkMemData>) : RecyclerView.Adapter<VkMemAdapter.VkMemViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VkMemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vkmem,parent,false)
        return VkMemViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: VkMemViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount() = items.size



    inner class VkMemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        private val memImage = itemView.findViewById<ImageView>(R.id.memImage)
        private val publicAvatar = itemView.findViewById<ImageView>(R.id.publicAvatar)
        private val nameMemPublic = itemView.findViewById<TextView>(R.id.nameMemPublic)
        private val date = itemView.findViewById<TextView>(R.id.date)
        private val comments = itemView.findViewById<TextView>(R.id.comments)
        private val likes = itemView.findViewById<TextView>(R.id.likes)

        fun bind(VkMemData: VkMemData)
        {
            memImage.setImageResource(VkMemData.MemImage)
            publicAvatar.setImageResource(VkMemData.publicAvatar)
            nameMemPublic.text = VkMemData.nameMemPublic
            date.text = VkMemData.date
            comments.text = VkMemData.comments
            likes.text = VkMemData.likes
        }
    }
}


