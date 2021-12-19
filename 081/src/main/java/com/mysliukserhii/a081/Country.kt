package com.mysliukserhii.a081

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class Country : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        val germany = findViewById<LinearLayout>(R.id.Germany)
        val france = findViewById<LinearLayout>(R.id.France)
        val england = findViewById<LinearLayout>(R.id.England)
        val poland = findViewById<LinearLayout>(R.id.Poland)

        val germanyText = findViewById<TextView>(R.id.GermanyText)
        val franceText = findViewById<TextView>(R.id.FranceText)
        val englandText = findViewById<TextView>(R.id.BritainText)
        val polandText = findViewById<TextView>(R.id.PolandText)

        germany.setOnClickListener{country(germanyText)}
        france.setOnClickListener{country(franceText)}
        poland.setOnClickListener{country(polandText)}
        england.setOnClickListener{country(englandText)}

    }

    private fun country(countryUser:TextView)
    {
        val returnIntent = Intent()
        returnIntent.putExtra("result", countryUser.text.toString())
        setResult(RESULT_OK, returnIntent)
        finish()
    }
}