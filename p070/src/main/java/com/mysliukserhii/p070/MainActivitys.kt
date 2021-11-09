package com.mysliukserhii.p070

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

class MainActivitys : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitys)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var Text = findViewById<TextView>(R.id.textView)
        var Image = findViewById<ImageView>(R.id.imageView)
        when(item.itemId)
        {
            R.id.menu_animal1 ->
            {
                Text.text = "Это медвед"
                Image.setImageResource(R.drawable.bear)
            }
        }
        when(item.itemId)
        {
            R.id.menu_animal2 ->
            {
                Text.text = "Это олень"
                Image.setImageResource(R.drawable.olen)
            }
        }
        when(item.itemId)
        {
            R.id.menu_animal3 ->
            {
                Text.text = "Это волк"
                Image.setImageResource(R.drawable.wolf)
            }
        }
        when(item.itemId)
        {
            R.id.menu_bird1 ->
            {
                Text.text = "Это воробей"
                Image.setImageResource(R.drawable.sparrow)
            }
        }
        when(item.itemId)
        {
            R.id.menu_bird2 ->
            {
                Text.text = "Это орел"
                Image.setImageResource(R.drawable.orel)
            }
        }
        when(item.itemId)
        {
            R.id.menu_bird3 ->
            {
                Text.text = "Это утка"
                Image.setImageResource(R.drawable.duck)
            }
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        var Animals = findViewById<RadioButton>(R.id.animalButton)
        var Birds = findViewById<RadioButton>(R.id.birdButton)

        if(Animals.isChecked)
        {
            menu?.setGroupVisible(R.id.animalGroup,true)
            menu?.setGroupVisible(R.id.birdsGroup,false)
        }
        if(Birds.isChecked)
        {
            menu?.setGroupVisible(R.id.animalGroup,false)
            menu?.setGroupVisible(R.id.birdsGroup,true)
        }
        return super.onPrepareOptionsMenu(menu)
    }
}