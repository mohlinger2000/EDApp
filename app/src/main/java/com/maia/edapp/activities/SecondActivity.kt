package com.maia.edapp.activities

import android.annotation.TargetApi
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maia.edapp.R
import java.util.*
import android.os.Build
import androidx.annotation.RequiresApi
import com.maia.edapp.db.FirebaseWriter
import com.maia.edapp.models.User
import android.view.LayoutInflater
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.*


class SecondActivity : AbstractActivity() {
    private val defaultUser = User("tobias@funke.com")
    //calendar button
    @RequiresApi(Build.VERSION_CODES.O)
    @TargetApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.setContentView(R.layout.activity_second)
        super.onCreate(savedInstanceState)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val fb = FirebaseWriter()
            val actualMonth = month + 1
            val monthString = if (actualMonth < 10) "0$actualMonth" else actualMonth.toString()
            val dayString = if (dayOfMonth < 10) "0$dayOfMonth" else dayOfMonth.toString()
            val date = "$year$monthString$dayString"
            fb.getMeals(defaultUser, date) { dm ->

                val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val popupView = inflater.inflate(R.layout.meal_popup, null)
                val width = LinearLayout.LayoutParams.WRAP_CONTENT
                val height = LinearLayout.LayoutParams.WRAP_CONTENT
                val focusable = true
                val popupWindow = PopupWindow(popupView, width, height, focusable)

                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)


                val breakfastText = popupView.findViewById(R.id.breakfast_list) as TextView
                val lunchText = popupView.findViewById(R.id.lunch_list) as TextView
                val dinnerText = popupView.findViewById(R.id.dinner_list) as TextView
                val sn1Text = popupView.findViewById(R.id.sn1_list) as TextView
                val sn2Text = popupView.findViewById(R.id.sn2_list) as TextView
                val sn3Text = popupView.findViewById(R.id.sn3_list) as TextView
                val breakfastList = dm["breakfast"]
                breakfastText.setText("Breakfast: $breakfastList")
                val lunchList = dm["lunch"]
                lunchText.setText("Lunch: $lunchList")
                val dinnerList = dm["dinner"]
                dinnerText.setText("Dinner: $dinnerList")
                val sn1List = dm["sn1"]
                sn1Text.setText("Snack 1: $sn1List")
                val sn2List = dm["sn2"]
                sn2Text.setText("Snack 2: $sn2List")
                val sn3List = dm["sn3"]
                sn3Text.setText("Snack 3: $sn3List")


                popupView.setOnTouchListener { _, _ ->
                    popupWindow.dismiss()
                    true
                }
            }
        }
    }
}
