package com.example.myfirstapp1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Random
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    companion object {
        const val TOTAL_COUNT = "total count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}