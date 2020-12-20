package com.example.randomcolorgenerator

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Color.*
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var genColorButton: Button
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var spinner1: Spinner
    private lateinit var bitmap: Bitmap
    private lateinit var colorwheel: ImageView
    private lateinit var colorbar: View
    private lateinit var resultcolor: TextView
    var selectedColor = 0 // the random created color

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genColorButton = findViewById(R.id.gen_color_button)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        spinner1 = findViewById(R.id.spinner1)
        colorwheel = findViewById(R.id.colorwheel)
        colorbar = findViewById(R.id.colorbar)
        resultcolor = findViewById(R.id.resultcolor)


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

                allColors()
                textView2.setBackgroundColor(selectedColor)
                textView2.setText("#"+Integer.toHexString(selectedColor))

                allColors()
                textView3.setBackgroundColor(selectedColor)
                textView3.setText("#"+Integer.toHexString(selectedColor))

                allColors()
                textView4.setBackgroundColor(selectedColor)
                textView4.setText("#"+Integer.toHexString(selectedColor))

            }
            else if(spinner1.selectedItemPosition == 1) {
                monochromatic(0)
                textView1.setBackgroundColor(selectedColor)
                textView1.setText("#"+Integer.toHexString(selectedColor))

                monochromatic(1)
                textView2.setBackgroundColor(selectedColor)
                textView2.setText("#"+Integer.toHexString(selectedColor))

                monochromatic(1)
                textView3.setBackgroundColor(selectedColor)
                textView3.setText("#"+Integer.toHexString(selectedColor))

                monochromatic(1)
                textView4.setBackgroundColor(selectedColor)
                textView4.setText("#"+Integer.toHexString(selectedColor))

            }
            else{ // FOR TESTING PURPOSES, ANY OTHER OPTION SELECTED
                textView1.setText("else")
                textView2.setText("else")
                textView3.setText("else")
                textView4.setText("else")
            }


        }
            colorwheel.isDrawingCacheEnabled = true
            colorwheel.buildDrawingCache(true)


            colorwheel.isDrawingCacheEnabled = true
            colorwheel.buildDrawingCache(true)
            colorwheel.setOnTouchListener { v, event ->
                 if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
                    bitmap = colorwheel.getDrawingCache()
                    val pixel = bitmap.getPixel(event.x.toInt(), event.y.toInt())
                    val r = Color.red(pixel)
                    val g = Color.green(pixel)
                    val b = Color.blue(pixel)
                    val hex = "#" + Integer.toHexString(pixel)
                    colorbar.setBackgroundColor(Color.rgb(r, g, b))
                    resultcolor.text = "RGB: $r, $g, $b \nHEX: $hex"
                    }
                 true
        }
    }

    fun  allColors(){ // the range of this is all
        // creates and stores the newly generated color int into selectedColor
        selectedColor = Color.argb((Random.nextInt(0,255)), Random.nextInt(0,255), Random.nextInt(0,255), Random.nextInt(0,255))
    }

    fun monochromatic(givenColor : Int){
        if(givenColor == 0){
            selectedColor = Color.argb((Random.nextInt(0,255)), Random.nextInt(0,255), Random.nextInt(0,255), Random.nextInt(0,255))
        }
        else{
            selectedColor = Color.argb((Random.nextInt(0,255)), selectedColor.red, selectedColor.green, selectedColor.blue)
        }
    }



}



