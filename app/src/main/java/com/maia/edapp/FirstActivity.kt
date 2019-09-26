package com.maia.edapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class FirstActivity : AppCompatActivity() {
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
