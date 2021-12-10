package com.mysliukserhii.a081

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Name : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        val editName = findViewById<EditText>(R.id.nameEdit)
        val buttonSave = findViewById<Button>(R.id.saveButton)
        val arguments = intent.extras
        editName.setText(arguments?.getString("nameText")!!.toString())
        buttonSave.setOnClickListener { saveButton(editName) }
    }

    private fun saveButton(editName: EditText) {
        if (editName.text.toString() != "") {
            val returnIntent = Intent()
            returnIntent.putExtra("result", editName.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
        else {
            Toast.makeText(
                this, "name should be not empty",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}