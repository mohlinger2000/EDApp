package com.maia.edapp.activities

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

        val action = Intent()
        action.data = Uri.parse("https://www.nationaleatingdisorders.org/")
        startActivity(action)
    }
}
