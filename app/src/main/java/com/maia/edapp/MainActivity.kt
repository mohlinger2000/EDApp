package com.maia.edapp

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


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonList = listOf<Button>(findViewById(R.id.breakfast),
            findViewById(R.id.lunch),
            findViewById(R.id.dinner),
            findViewById(R.id.sn1),
            findViewById(R.id.sn2),
            findViewById(R.id.sn3))
        buttonList.forEach{b -> b.setOnClickListener{addMeal(b)}}
    }

    private fun addMeal(b: Button) {
        val textbox = EditText(this)
        var addedText: String //TODO: add to database
        val dialog = AlertDialog.Builder(this)
            .setMessage("Enter your meal:")
            .setTitle("Meal Input")
            .setView(textbox)
            .setPositiveButton("Add") {_, _ -> addedText = textbox.text.toString()}
            .setNegativeButton("Cancel"){_, _ -> }
        val alertDialog = dialog.create()
        alertDialog.show()
    }
}
