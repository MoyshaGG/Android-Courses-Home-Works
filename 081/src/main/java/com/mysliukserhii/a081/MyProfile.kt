package com.mysliukserhii.a081

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import de.hdodenhof.circleimageview.CircleImageView

import android.widget.TextView


class MyProfile : AppCompatActivity() {
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_SELECT_IMAGE_IN_ALBUM = 2
    private val REQUEST_CHANGE_NAME = 3
    private val REQUEST_CHANGE_COUNTRIES = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        val countryButton = findViewById<TextView>(R.id.countryButton)
        val countryFlag = findViewById<ImageView>(R.id.country)
        val batman = findViewById<CircleImageView>(R.id.batman)
        val nameButton = findViewById<TextView>(R.id.nameButton)
        val nameLayout = findViewById<LinearLayout>(R.id.nameLayout)
        val countryLayout = findViewById<LinearLayout>(R.id.linearCountry)

        val nameLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == RESULT_OK)
            {
                nameButton.text = it.data?.getStringExtra("result").toString()
            }
        }
        val countryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == RESULT_OK)
            {
                countryButton.text = it.data?.getStringExtra("result").toString()
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

        nameLayout.setOnClickListener { intentButtonName(nameButton,nameLauncher) }
        countryLayout.setOnClickListener { intentButtonCountry(countryLauncher) }
        val getImage = registerForActivityResult(
            ActivityResultContracts.GetContent(),
        ActivityResultCallback {if(it!=null)
            batman.setImageURI(it) })

        val galleryButton = findViewById<ImageButton>(R.id.galleryButton)

        galleryButton.setOnClickListener {
            val popupmenu = PopupMenu(this, galleryButton)
            popupmenu.menuInflater.inflate(R.menu.poopupmenu, popupmenu.menu)
            popupmenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.title) {
                    "gallery" -> selectImageInAlbum(getImage)
                    "photo" -> dispatchTakePictureIntent()
                }
                true
            })
            popupmenu.show()
        }
    }
    private fun intentButtonName(textView: TextView, nameLauncher: ActivityResultLauncher<Intent>) {
        val intent = Intent(this, Name::class.java)
        intent.putExtra("nameText", textView.text.toString())
        nameLauncher.launch(intent)
    }

         private fun intentButtonCountry(countryLauncher: ActivityResultLauncher<Intent>) {
             val intent = Intent(this,Country::class.java)
             countryLauncher.launch(intent)
    }

    private fun selectImageInAlbum(getImage:ActivityResultLauncher<String>) {
        getImage.launch("image/*")
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
g
  }

}