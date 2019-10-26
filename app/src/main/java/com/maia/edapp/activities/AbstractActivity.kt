package com.maia.edapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.maia.edapp.R




abstract class AbstractActivity : AppCompatActivity() {
    protected lateinit var fullLayout: RelativeLayout;
    protected lateinit var subActivityContent: FrameLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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