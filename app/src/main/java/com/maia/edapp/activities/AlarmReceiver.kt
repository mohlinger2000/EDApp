package com.maia.edapp.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.PowerManager
import android.os.Vibrator
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context : Context, intent : Intent) {
        Toast.makeText(context, "Alarm Received", Toast.LENGTH_LONG).show()

        val notification : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
        val ringtone : Ringtone = RingtoneManager.getRingtone(context, notification)
        ringtone.play()

        val vibrator : Vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(5000)

        val PARTIAL_WAKE_LOCK = 32
        val powerMan : PowerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        val wakeLock1 : PowerManager.WakeLock = powerMan.newWakeLock(PARTIAL_WAKE_LOCK, "AppName:tag")
        wakeLock1.acquire()

        wakeLock1.release()
    }
}