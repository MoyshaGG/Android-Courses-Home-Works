package com.mysliukserhii.a081

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import de.hdodenhof.circleimageview.CircleImageView

class MyProfile : AppCompatActivity() {
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_SELECT_IMAGE_IN_ALBUM = 2
    private val REQUEST_CHANGE_NAME = 3
    private val REQUEST_CHANGE_COUNTRIES = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        val nameButton = findViewById<TextView>(R.id.nameButton)
        val nameLayout = findViewById<LinearLayout>(R.id.nameLayout)
        nameLayout.setOnClickListener { intentButtonName(nameButton) }
        val countryLayout = findViewById<LinearLayout>(R.id.linearCountry)
        countryLayout.setOnClickListener { intentButtonCountry() }

        val galleryButton = findViewById<ImageButton>(R.id.galleryButton)
        galleryButton.setOnClickListener {
            val popupmenu = PopupMenu(this, galleryButton)
            popupmenu.menuInflater.inflate(R.menu.poopupmenu, popupmenu.menu)
            popupmenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.title) {
                    "gallery" -> selectImageInAlbum()
                    "photo" -> dispatchTakePictureIntent()
                }
                true
            })
            popupmenu.show()
        }
    }

    private fun intentButtonName(textView: TextView) {
        val intent = Intent(this, Name::class.java)
        intent.putExtra("nameText", textView.text.toString())
        startActivityForResult(intent, REQUEST_CHANGE_NAME)
    }

    private fun intentButtonCountry() {
        val intent = Intent(this,Country::class.java)
        startActivityForResult(intent, REQUEST_CHANGE_COUNTRIES)
    }



    private fun selectImageInAlbum() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
        }
    }


    private fun dispatchTakePictureIntent() {

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                this, "fail",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        val photoView = findViewById<CircleImageView>(R.id.batman)

        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            val imageBitmap = data?.getParcelableExtra<Bitmap>("data")
            photoView.setImageBitmap(imageBitmap)
        }
        if (requestCode == REQUEST_SELECT_IMAGE_IN_ALBUM) {
            val imageBitmap = data?.data
            photoView.setImageURI(imageBitmap)
        }
        if (requestCode == REQUEST_CHANGE_NAME) {
            if(data?.getStringExtra("result") != null)
            {
                val nameButton = findViewById<TextView>(R.id.nameButton)
                nameButton.text = data?.getStringExtra("result").toString()
            }

        }
        if (requestCode == REQUEST_CHANGE_COUNTRIES) {
            if (data?.getStringExtra("result") != null) {
                val countryButton = findViewById<TextView>(R.id.countryButton)
                val countryFlag = findViewById<ImageView>(R.id.country)
                countryButton.text = data?.getStringExtra("result").toString()

                if (countryButton.text == "Germany") {
                    countryFlag.setImageResource(R.drawable.germany)
                }
                if (countryButton.text == "Poland") {
                    countryFlag.setImageResource(R.drawable.poland)
                }
                if (countryButton.text == "Britain") {
                    countryFlag.setImageResource(R.drawable.britain)
                }
                if (countryButton.text == "France") {
                    countryFlag.setImageResource(R.drawable.france)
                }
            }

        }

    }

}