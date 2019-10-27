package com.maia.edapp.activities

import android.annotation.TargetApi
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.maia.edapp.R
import android.widget.Toast
import android.os.PowerManager
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import android.icu.util.Calendar
import android.media.Ringtone
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi


class FourthActivity : AbstractActivity() {
    //alarm button
    var myTimePicker: TimePicker? = null
    lateinit var buttonstartSetDialog : Button
    lateinit var buttonstopSetDialog : Button
    lateinit var textAlarmPrompt : TextView
    var timePickerDialog : TimePickerDialog? = null
    val RQS_1 = 1
    private lateinit var alarmIntent : PendingIntent
    private var alarmMgr : AlarmManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.setContentView(R.layout.activity_fourth)
        super.onCreate(savedInstanceState)

        val textAlarmPrompt = findViewById<TextView>(R.id.alarmPrompt)
        buttonstartSetDialog = findViewById<Button>(R.id.startSetDialog)
        buttonstartSetDialog.setOnClickListener {v ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    openTimePickerDialog(false)
                }
            }
        buttonstopSetDialog = findViewById<Button>(R.id.stopSetDialog)
        buttonstopSetDialog.setOnClickListener {v ->
                cancelAlarm(this@FourthActivity)
        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun openTimePickerDialog(is24r : Boolean) {
        val calendar : Calendar = Calendar.getInstance()
        val timeSetListener : TimePickerDialog.OnTimeSetListener = TimePickerDialog.OnTimeSetListener {view, hourOfDay, minute ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val calendarNow: Calendar = Calendar.getInstance()
                val calendarSet: Calendar = calendarNow.clone() as Calendar
                calendarSet.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendarSet.set(Calendar.MINUTE, minute)
                calendarSet.set(Calendar.SECOND, 0)
                calendarSet.set(Calendar.MILLISECOND, 0)

                if (calendarSet.compareTo(calendarNow) <= 0) {
                    calendarSet.add(Calendar.DATE, 1)
                }
                setAlarm(calendarSet)
            }
        }
        timePickerDialog = TimePickerDialog(this@FourthActivity,
            timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), is24r)
        timePickerDialog!!.setTitle("Set Alarm Time")
        timePickerDialog!!.show()
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun setAlarm(targetCalendar : Calendar) {
        alarmMgr = this@FourthActivity.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmIntent = Intent(this@FourthActivity, AlarmReceiver::class.java).let {intent ->
            PendingIntent.getBroadcast(this@FourthActivity, 1, intent, 0)
        }
        alarmMgr?.set(
            AlarmManager.RTC_WAKEUP,
            targetCalendar.getTimeInMillis(),
            alarmIntent
        )
    }
    fun cancelAlarm(context : Context) {
        Toast.makeText(context, "Alarm has been canceled.", Toast.LENGTH_LONG).show()
        val intent = Intent(context, AlarmReceiver::class.java)
        val sender : PendingIntent = PendingIntent.getBroadcast(context, 1 , intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager : AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(sender)
    }
}

