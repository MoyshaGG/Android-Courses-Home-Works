package earthquake.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mysliukserhii.p111_20.R
import model.EarthQuakeDto
import model.FeatureDto
import ui.EarthQuakeDvo

import java.util.*

interface OnItemClickListener {
    fun onClick(feature: Int)
}

class QuakeAdapter (private val onItemClickListener: OnItemClickListener, var features: List<EarthQuakeDvo> = emptyList())
    :RecyclerView.Adapter<QuakeAdapter.QuakeViewHolder>() //adapterNotCanon
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeAdapter.QuakeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_earthquake,parent,false)
        return QuakeViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuakeAdapter.QuakeViewHolder, position: Int) {
        features[position].let{holder.bind(it)}
    }
    override fun getItemCount(): Int {
        return features.size
    }
    inner class QuakeViewHolder(view:View): RecyclerView.ViewHolder(view){
        private val time = view.findViewById<TextView>(R.id.time)
        private val location = view.findViewById<TextView>(R.id.locationEarthquake)
        private val intensity = view.findViewById<TextView>(R.id.intensity)
        private val magnitude = view.findViewById<TextView>(R.id.magnitude)
        fun bind (quakeAlertDvo: EarthQuakeDvo)
        {
            time?.text = quakeAlertDvo.time
            location?.text = quakeAlertDvo.location
            intensity?.text = quakeAlertDvo.intensityTitle.toString()
            intensity?.setBackgroundResource(quakeAlertDvo.color)
            magnitude?.text = quakeAlertDvo.magnitude
            itemView.setOnClickListener{
                onItemClickListener.onClick(itemId.toInt())
            }
        }
//        override fun onClick(v:View?){
//            clickListener.onItemClick(features[adapterPosition])
//        }
    }
}