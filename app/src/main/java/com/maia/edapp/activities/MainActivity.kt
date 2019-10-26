package com.maia.edapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.maia.edapp.R
import com.maia.edapp.db.FirebaseWriter
import com.maia.edapp.models.User


class MainActivity : AbstractActivity() {

    private val defaultUser = User("tobias@funke.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        //main screen

        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        listOf<Button>(findViewById(R.id.breakfast),
            findViewById(R.id.lunch),
            findViewById(R.id.dinner),
            findViewById(R.id.sn1),
            findViewById(R.id.sn2),
            findViewById(R.id.sn3))
            .forEach{b -> b.setOnClickListener{addMeal(b)}}

        val waterButton = findViewById<Button>(R.id.water)
        waterButton.setOnClickListener{goToFirstActivity()}

        val alarmButton = findViewById<Button>(R.id.setAlarm)
        alarmButton.setOnClickListener{goToFourthActivity()}
    }

    private fun addMeal(b: Button) {
        val database = FirebaseWriter()
        val textbox = EditText(this)
        var addedText: String//
        val dialog = AlertDialog.Builder(this)
            .setMessage("Enter your meal:")
            .setTitle("Meal Input")
            .setView(textbox)
            .setPositiveButton("Add") {_, _ -> run {
                addedText = textbox.text.toString()
                if(addedText != "") {
                    database.addMeal(addedText, defaultUser, when(b.text.toString().toLowerCase()) {
                        "snack 1" -> "sn1"
                        "snack 2" -> "sn2"
                        "snack 3" -> "sn3"
                        else -> b.text.toString().toLowerCase()
                    })
                }
            }}
            .setNegativeButton("Cancel"){_, _ -> }
        val alertDialog = dialog.create()
        alertDialog.show()
    }

    private fun goToFirstActivity() {
        val intent = Intent(this@MainActivity, FirstActivity::class.java)
        startActivity(intent)
    }

    private fun goToFourthActivity() {
        val intent = Intent(this@MainActivity, FourthActivity::class.java)
        startActivity(intent)
    }
}
