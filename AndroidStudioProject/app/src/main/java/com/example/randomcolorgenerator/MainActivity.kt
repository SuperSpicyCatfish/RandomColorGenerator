package com.example.randomcolorgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var genColorButton: Button
    private lateinit var textView1: TextView
    private lateinit var spinner1: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genColorButton = findViewById(R.id.gen_color_button)
        textView1 = findViewById(R.id.textView1)
        spinner1 = findViewById(R.id.spinner1)


        genColorButton.setOnClickListener { view: View ->
            textView1.setBackgroundColor(resources.getColor(R.color.teal_200))
            textView1.setText("boop")

        }


    }
}