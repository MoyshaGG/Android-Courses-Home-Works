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
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import de.hdodenhof.circleimageview.CircleImageView

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        val galleryButton = findViewById<ImageButton>(R.id.galleryButton)
        galleryButton.setOnClickListener{
            val popupmenu = PopupMenu(this,galleryButton)
            popupmenu.menuInflater.inflate(R.menu.poopupmenu,popupmenu.menu)
            popupmenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.title) {
                    "gallery" -> dispatchTakePictureIntent()
                    "camera" -> dispatchTakePictureIntent()
                }
                true
            })
            popupmenu.show()
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

        if(requestCode == REQUEST_IMAGE_CAPTURE)
        {
            val imageBitmap = data?.getParcelableExtra<Bitmap>("data")
            photoView.setImageBitmap(imageBitmap)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
    }


}