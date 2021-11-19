package com.mysliukserhii.a081

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import de.hdodenhof.circleimageview.CircleImageView

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        val nameButton = findViewById<TextView>(R.id.nameButton)
        nameButton.setOnClickListener{intentButtonText(nameButton)}

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
    fun intentButtonText(textView: TextView)
    {
        val intent = Intent(this,Name::class.java)
        intent.putExtra("nameText",textView.text.toString())
        startActivityForResult(intent,3)
    }


    val REQUEST_SELECT_IMAGE_IN_ALBUM = 2

    fun selectImageInAlbum() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
        }
    }

    val REQUEST_IMAGE_CAPTURE = 1

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
            if(requestCode == 3)
            {
                val nameButton = findViewById<TextView>(R.id.nameButton)
                nameButton.setText(data?.getStringExtra("result").toString())
            }
    }
    
}