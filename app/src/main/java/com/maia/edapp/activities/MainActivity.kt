package com.maia.edapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import android.widget.EditText
import com.maia.edapp.R


class MainActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

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
        val textbox = EditText(this)
        var addedText: String //TODO: add to database
        val dialog = AlertDialog.Builder(this)
            .setMessage("Enter your meal:")
            .setTitle("Meal Input")
            .setView(textbox)
            .setPositiveButton("Add") {_, _ -> addedText = textbox.text.toString()}
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
