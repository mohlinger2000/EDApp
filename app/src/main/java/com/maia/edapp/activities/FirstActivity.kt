package com.maia.edapp.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import com.maia.edapp.R
import com.maia.edapp.db.FirebaseWriter
import com.maia.edapp.models.User

class FirstActivity : AbstractActivity() {
    private val defaultUser = User("tobias@funke.com")

    //water button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.setContentView(R.layout.activity_first)
        super.onCreate(savedInstanceState)
        val db = FirebaseWriter()

        db.getWater(defaultUser) {numWater ->
            var tempNumWater = numWater
            listOf<Button>(findViewById(R.id.cup1),
                findViewById(R.id.cup2),
                findViewById(R.id.cup3),
                findViewById(R.id.cup4),
                findViewById(R.id.cup5),
                findViewById(R.id.cup6),
                findViewById(R.id.cup7),
                findViewById(R.id.cup8))
                .forEach{b ->
                    if (tempNumWater > 0) {
                        b.setBackgroundColor(Color.BLUE)
                        b.isClickable = false
                        b.isEnabled = false
                        tempNumWater--
                    }
                    b.setOnClickListener{trackWater(b)}}
        }
    }

    private fun trackWater(b : Button) {
        val db = FirebaseWriter()
        db.addWater(defaultUser)
        b.setBackgroundColor(Color.BLUE)
        b.isClickable = false
        b.isEnabled = false

    }
}
