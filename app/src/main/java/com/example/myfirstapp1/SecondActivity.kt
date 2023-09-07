package com.example.myfirstapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        imageView = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)
        textView2 = findViewById(R.id.textView2)
    }
    private lateinit var imageView: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageView5: ImageView
    private lateinit var imageView6: ImageView
    private lateinit var textView2: TextView
    fun addNum(view: View){
        addN(view, 1)
    }
    fun addNum2(view: View){
        addN(imageView2, 2) }
    fun addNum3(view: View){
        addN(imageView3, 3) }
    fun addNum4(view: View){
        addN(imageView4, 4) }
    fun addNum5(view: View){
        addN(imageView5, 5) }
    fun addNum6(view: View){
        addN(imageView6, 6) }
    private fun addN(view: View, add1: Int){
        var count:Int = Integer.parseInt(textView2.text.toString())
        count += add1; textView2.text = count.toString()
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        view.startAnimation(wacircAnimation)
    }

}