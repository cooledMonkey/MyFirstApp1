package com.example.myfirstapp1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


// MARK:- First view
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)
        constraintLayout = findViewById(R.id.constraintLayout)
        imageView.layoutParams.height = 200
        textView.text = imageView.layoutParams.height.toString()
        imageView.setColorFilter(Color.argb(alfa,red, green, blue))
    }

    private var alfa = 255; private var red = 255; private var green = 255;private var blue = 255
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var constraintLayout: ConstraintLayout
    fun countMe (@Suppress("UNUSED_PARAMETER")view: View) {
        var count: Int = (imageView.layoutParams.height)
        count += 200
        val sizeRiseAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sunrise)
        imageView.startAnimation(sizeRiseAnimation)
        val sinRiseAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sunset)
        imageView.startAnimation(sinRiseAnimation)
        imageView.layoutParams.height = count
        imageView.layoutParams.width = count
        textView.text = count.toString()
        if (count > 2340){
            constraintLayout.setBackgroundColor(Color.argb(alfa, red, green, blue))
            imageView.layoutParams.height = 200
            imageView.layoutParams.width = 200
            alfa = (0..255).random();red = (0..255).random()
            green = (0..255).random();blue = (0..255).random()
            imageView.setColorFilter(Color.argb(alfa,red, green, blue))
        }
    }

    fun randomMe(@Suppress("UNUSED_PARAMETER")view: View){
        val randomIntent = Intent(this, SecondActivity::class.java)
        startActivity(randomIntent)
    }

}


