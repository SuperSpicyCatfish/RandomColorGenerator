package com.example.randomcolorgenerator

import android.graphics.Color.convert
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var genColorButton: Button
    private lateinit var textView1: TextView
    private lateinit var spinner1: Spinner
    // random values for RGB
    var randR = 0
    var randG = 0
    var randB = 0
    var temp = 0
    // current position of the spinner, there are 6 choices, so 0-5 are valid numbers
    var currentPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genColorButton = findViewById(R.id.gen_color_button)
        textView1 = findViewById(R.id.textView1)
        spinner1 = findViewById(R.id.spinner1)


        // this is for the spinner
        ArrayAdapter.createFromResource(this,R.array.color_options,android.R.layout.simple_spinner_item).also{
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }




        genColorButton.setOnClickListener { view: View ->
            allColors()
            temp = rgb(randR,randG,randB)

            // Integer.toHexString(temp)
            textView1.setBackgroundColor(resources.getColor(R.color.teal_200))
            textView1.setText(randR.toString())

        }

    }

    fun  allColors(){
        randR = Random.nextInt(0,255)
        randG = Random.nextInt(0,255)
        randB = Random.nextInt(0,255)
    }


}