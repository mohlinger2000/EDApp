package com.maia.edapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maia.edapp.R

class SecondActivity : AbstractActivity() {
    //calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}