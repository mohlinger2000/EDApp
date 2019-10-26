package com.maia.edapp.activities

import android.annotation.TargetApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maia.edapp.R
import java.util.*
import android.os.Build
import androidx.annotation.RequiresApi
import android.widget.CalendarView
import android.widget.Toast


class SecondActivity : AbstractActivity() {
    //calendar button
    @RequiresApi(Build.VERSION_CODES.O)
    @TargetApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.setContentView(R.layout.activity_second)
        super.onCreate(savedInstanceState)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val msg = "Selected date is " + (month + 1) + "/" + dayOfMonth + "/" + year
            Toast.makeText(this@SecondActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
