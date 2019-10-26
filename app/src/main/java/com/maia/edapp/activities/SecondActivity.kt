package com.maia.edapp.activities

import android.annotation.TargetApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maia.edapp.R
import java.util.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId

class SecondActivity : AbstractActivity() {
    //calendar button
    @RequiresApi(Build.VERSION_CODES.O)
    @TargetApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_second)

        val date = Date()
        val localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val cal = Calendar.getInstance(TimeZone.getTimeZone("America/New York"))
        cal.time = date
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
    }
}
