package com.maia.edapp.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import com.maia.edapp.R

class FirstActivity : AbstractActivity() {
    //water
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        listOf<Button>(findViewById(R.id.cup1),
            findViewById(R.id.cup2),
            findViewById(R.id.cup3),
            findViewById(R.id.cup4),
            findViewById(R.id.cup5),
            findViewById(R.id.cup6),
            findViewById(R.id.cup7),
            findViewById(R.id.cup8))
            .forEach{b -> b.setOnClickListener{trackWater(b)}}
    }

    private fun trackWater(b : Button) {
        b.setBackgroundColor(Color.BLUE)
    }
}