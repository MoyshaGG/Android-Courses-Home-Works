package com.mysliukserhii.p1112.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mysliukserhii.p1112.Magnitude
import com.mysliukserhii.p1112.R
import com.mysliukserhii.p1112.model.Feature
import com.mysliukserhii.p1112.model.Quakes
import com.mysliukserhii.p1112.ui.detailed.DetailedFragment

class QuakesAdapter(private val quakes: Quakes) :
    RecyclerView.Adapter<QuakesAdapter.ViewHolder>() {
    var onItemClick: ((Feature) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        quakes.features?.let { holder.bind(it.get(position)) }
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                activity.supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.con_main,
                        DetailedFragment.newInstance(quakes.features[holder.adapterPosition])
                    )
                    .addToBackStack("tag").commit()
            }
        })
    }

    override fun getItemCount() = quakes.features.size

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        val intenseTextView: TextView = itemView.findViewById(R.id.intenseTextView)
        val quakeValueTextView: TextView = itemView.findViewById(R.id.quakeValueTextView)

        @SuppressLint("ResourceType")
        fun bind(feature: Feature) {
            timeTextView.text = feature.properties.time.substring(0, 10)
            locationTextView.text = feature.properties.locality
            quakeValueTextView.text = String.format("%.1f", feature.properties.magnitude)
            val dvo = initMagnitude(feature.properties.magnitude)
            intenseTextView.setText(dvo.title)
            intenseTextView.setBackgroundResource(dvo.color)
        }

        private fun initMagnitude(magnitude: Double): Magnitude {
            return when (magnitude) {
                in 1.0..1.99 -> Magnitude.VERY_LOW
                in 2.0..2.99 -> Magnitude.WEAK
                in 3.0..4.49 -> Magnitude.MEDIUM
                in 4.5..5.99 -> Magnitude.STRONG
                else -> Magnitude.VERY_STRONG
            }
        }
    }
}