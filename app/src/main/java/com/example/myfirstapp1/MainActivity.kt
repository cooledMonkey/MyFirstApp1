package com.example.myfirstapp1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)
        imageView.layoutParams.height = 200
        textView.text = imageView.layoutParams.height.toString()
        //scrollDetector = new MyGestureListener(this, imageView)
    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    fun countMe (view: View) {
        var count: Int = (imageView.layoutParams.height)
        count += 10
        imageView.layoutParams.height = count
        imageView.layoutParams.width = count
        textView.text = count.toString()
    }

    fun minCountMe (view: View) {
        var count: Int = (imageView.layoutParams.height)
        count -= 10
        imageView.layoutParams.height = count
        imageView.layoutParams.width = count
        textView.text = count.toString()
    }

    fun randomMe(view: View){
        val randomIntent = Intent(this, SecondActivity::class.java)
        val countString = textView.text.toString()
        val count = Integer.parseInt(countString)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
        startActivity(randomIntent)
    }

}

