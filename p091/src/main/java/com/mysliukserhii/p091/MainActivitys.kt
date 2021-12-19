package com.mysliukserhii.p091

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivitys : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        var text = findViewById<TextView>(R.id.textView)
        var image = findViewById<ImageView>(R.id.imageView)
        viewModel.natureLiveData?.observe(this) {
            text.text = it.description
            image?.setImageResource(it.picture)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.loadNatureData(item.itemId)
            return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        var animals = findViewById<RadioButton>(R.id.animalButton)
        var birds = findViewById<RadioButton>(R.id.birdButton)
        if(animals.isChecked)
        {
            menu?.setGroupVisible(R.id.animalGroup,true)
            menu?.setGroupVisible(R.id.birdsGroup,false)
        }
        if(birds.isChecked)
        {
            menu?.setGroupVisible(R.id.animalGroup,false)
            menu?.setGroupVisible(R.id.birdsGroup,true)
        }
        return super.onPrepareOptionsMenu(menu)
    }
}
