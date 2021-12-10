package com.mysliukserhii.p104

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class GameAdapter (private val items:List<GameData>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game,parent,false)
        return GameViewHolder((itemView))
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(items[position])
    }
    override fun getItemCount() = items.size



    inner class GameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        private val imageGame = itemView.findViewById<ImageView>(R.id.imageGame)
        private val nameGame = itemView.findViewById<TextView>(R.id.nameGame)
        private val dateGame = itemView.findViewById<TextView>(R.id.dateGame)
        private val price = itemView.findViewById<TextView>(R.id.price)

        fun bind(GameData: GameData)
        {
            imageGame.setImageResource(GameData.imageGame)
            nameGame.text = GameData.nameGame
            dateGame.text = GameData.dateGame
            price.text = GameData.price
        }
    }
}


