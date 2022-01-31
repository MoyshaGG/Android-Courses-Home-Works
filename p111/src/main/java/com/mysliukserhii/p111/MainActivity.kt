package com.mysliukserhii.p111

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import eathquake.adapter.OnItemClickListener
import eathquake.adapter.QuakeAdapter
import viewmodel.DetailsRecommendationsFragmentViewModel
import viewmodel.MainEarthQuakeViewModel

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var mainEarthQuakeViewModel: MainEarthQuakeViewModel
    private lateinit var recyclerView: RecyclerView
  //  private lateinit var quakeAlert = QuakeAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        recyclerView = findViewById(R.id.recycle)
        recyclerView.adapter = QuakeAdapter(this)

        mainEarthQuakeViewModel = ViewModelProvider(this).get(MainEarthQuakeViewModel::class.java)

        mainEarthQuakeViewModel.earthquakeLiveData.observe(this)
        {
//            setEarthQuake(time,location,intensity,magnitude)
        }

    }

    private val time = findViewById<TextView>(R.id.time)
    private val location = findViewById<TextView>(R.id.locationEarthquake)
    private val intensity = findViewById<TextView>(R.id.intensity)
    private val magnitude = findViewById<TextView>(R.id.magnitude)

//    private fun setEarthQuake(time: TextView,location:TextView,intensity:TextView,magnitude:TextView) {
//
//
//    }

    override fun onClick(feature: Int) {}
//        val backStackEntryCount = findViewById<Class<DetailsRecommendationsFragment>>
//        startActivityFromFragment(DetailsRecommendationsFragment)


}


