package com.maia.edapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.maia.edapp.R
import com.maia.edapp.db.FirebaseWriter
import com.maia.edapp.models.User


class MainActivity : AppCompatActivity() {



    private val defaultUser = User("tobias@funke.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listOf<Button>(findViewById(R.id.breakfast),
            findViewById(R.id.lunch),
            findViewById(R.id.dinner),
            findViewById(R.id.sn1),
            findViewById(R.id.sn2),
            findViewById(R.id.sn3))
            .forEach{b -> b.setOnClickListener{addMeal(b)}}
    }

    private fun addMeal(b: Button) {
        val database = FirebaseWriter()
        val textbox = EditText(this)
        var addedText = "" //TODO: add to database
        val dialog = AlertDialog.Builder(this)
            .setMessage("Enter your meal:")
            .setTitle("Meal Input")
            .setView(textbox)
            .setPositiveButton("Add") {_, _ -> run {
                addedText = textbox.text.toString()
                if(addedText != "") {
                    database.addMeal(addedText, defaultUser, b.text.toString().toLowerCase()) //TODO: snacks need to be configured
                }
            }}
            .setNegativeButton("Cancel"){_, _ -> }
        val alertDialog = dialog.create()
        alertDialog.show()
    }
}
