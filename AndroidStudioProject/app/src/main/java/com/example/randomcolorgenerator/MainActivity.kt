package com.example.randomcolorgenerator

import android.app.Activity
import android.graphics.Color
import android.graphics.Color.*
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var genColorButton: Button
    private lateinit var textView1: TextView
    private lateinit var spinner1: Spinner

    var selectedColor = 0 // the random created color

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genColorButton = findViewById(R.id.gen_color_button)
        textView1 = findViewById(R.id.textView1)
        spinner1 = findViewById(R.id.spinner1)


        // this is for the spinner
        ArrayAdapter.createFromResource(this,R.array.color_options,android.R.layout.simple_spinner_item).also{
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter // setAdapter
        }



        // when the user clicks the generate button
        genColorButton.setOnClickListener { view: View ->

            if(spinner1.selectedItemPosition == 0){ // ALL COLORS OPTION SELECTED
                allColors() // generates the new color
                textView1.setBackgroundColor(selectedColor)
                textView1.setText("#"+Integer.toHexString(selectedColor))
            }
            else{ // FOR TESTING PURPOSES, ANY OTHER OPTION SELECTED
                textView1.setText("else")
            }


        }

    }

    fun  allColors(){ // the range of this is all
        // creates and stores the newly generated color int into selectedColor
        selectedColor = Color.argb((Random.nextInt(0,255)), Random.nextInt(0,255), Random.nextInt(0,255), Random.nextInt(0,255))
    }




}



