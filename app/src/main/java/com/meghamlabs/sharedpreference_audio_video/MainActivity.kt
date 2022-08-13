package com.meghamlabs.sharedpreference_audio_video

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    private lateinit var weightText: EditText
    private lateinit var heightText: EditText
    private lateinit var sf: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightText = findViewById(R.id.weight)
        heightText = findViewById(R.id.height)
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()

    }

    override fun onPause() {
        super.onPause()
        val weight = weightText.text.toString().toInt()
        val height = heightText.text.toString().toInt()
        editor.apply {
            putInt("sf_weight", weight)
            putInt("sf_height", height)
            commit()
        }

    }

    override fun onResume() {
        super.onResume()
        val weight = sf.getInt("sf_weight", 0)
        val height = sf.getInt("sf_height", 0)

        if(weight!=0) {
            weightText.setText(weight.toString())
        }
        if(height!=0) {
            heightText.setText(height.toString())
        }

    }

}