package com.maia.edapp.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import com.maia.edapp.R

class ThirdActivity : AbstractActivity() {
    //resources button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.setContentView(R.layout.activity_third)
        super.onCreate(savedInstanceState)

        var title : TextView = findViewById(R.id.title)
        var link : TextView = findViewById(R.id.link)
        val action = Intent()
        action.data = Uri.parse("https://www.nationaleatingdisorders.org/")
        startActivity(action)
    }
}
