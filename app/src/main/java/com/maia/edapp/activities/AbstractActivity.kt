package com.maia.edapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.maia.edapp.R

abstract class AbstractActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarButton = findViewById<Button>(R.id.calendar)
        calendarButton.setOnClickListener{goToSecondActivity()}

        val resourcesButton = findViewById<Button>(R.id.resources)
        resourcesButton.setOnClickListener{goToThirdActivity()}

        val mealButton = findViewById<Button>(R.id.meals)
        mealButton.setOnClickListener{goToMainActivity()}
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    private fun goToThirdActivity() {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}