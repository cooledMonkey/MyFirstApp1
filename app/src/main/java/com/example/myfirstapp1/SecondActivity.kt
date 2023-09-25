package com.example.myfirstapp1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils.concat
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.lang.Integer.parseInt
import java.util.Timer
import java.util.TimerTask


//  TODO: сохранение состояний кнопок и цветовой гаммы фигур


var isLightTheme = false
var  flagBud2 = 0
var  flagBud3 = false
var  flagBud4 = false
var  flagBud5 = false
var  flagBud6 = false
class SecondActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        if (isLightTheme == false) {
            setTheme(R.style.Base_Theme_MyFirstApp1)
        } else if (isLightTheme == true) {
            setTheme(R.style.Theme_MyFirstApp1)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
        drawer = findViewById(R.id.drawer_layou)
        toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.setDrawerIndicatorEnabled(true)
        toggle.syncState()
        imageView = findViewById(R.id.imageView)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)
        textView2 = findViewById(R.id.textView2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView9 = findViewById(R.id.textView9)
        textView7 = findViewById(R.id.textView7)
        textView8 = findViewById(R.id.textView8)
        imageView21 = findViewById(R.id.imageView21)
        imageView11 = findViewById(R.id.imageView11)
        imageView31 = findViewById(R.id.imageView31)
        imageView41 = findViewById(R.id.imageView41)
        imageView51 = findViewById(R.id.imageView51)
        imageView61 = findViewById(R.id.imageView61)
        constraintLayout2 = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)
    }
    companion object {
        const val flagPas = "total_count"
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.drawer_items, menu);
        return super.onCreateOptionsMenu(menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.getItemId()){
//            R.id.app_bar_switch ->
//                if (item.isChecked){
//                    item.setChecked(false)
//                    Toast.makeText(this, "YES", Toast.LENGTH_LONG)
//                }
//                else{
//                    item.setChecked(true)
//                    Toast.makeText(this, "NO", Toast.LENGTH_LONG)
//                }
//        }
//        return super.onOptionsItemSelected(item)
//    }
    private lateinit var navView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var constraintLayout2: ConstraintLayout
    override fun onSaveInstanceState(outState: Bundle) {

        outState?.run {
            putString("KEY", textView2.text.toString())
            putString("KeyTVL", textView3.text.toString())
            putString("KeyTVL2", textView4.text.toString())
            putString("KeyTVL3", textView5.text.toString())
            putString("KeyTVL4", textView7.text.toString())
            putString("KeyTVL5", textView8.text.toString())
            putString("KeyTVL6", textView9.text.toString())
            putString("KeyBut3Tx", button3.text.toString())
            putString("KeyBut4Tx", button4.text.toString())
            putString("KeyBut5Tx", button5.text.toString())
            putString("KeyBut6Tx", button6.text.toString())
            putString("KeyBut7Tx", button7.text.toString())
            putString("KeyBut8Tx", button8.text.toString())
        }

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView2.text = savedInstanceState.getString("KEY")
        textView3.text = savedInstanceState.getString("KeyTVL")
        textView4.text = savedInstanceState.getString("KeyTVL2")
        textView5.text = savedInstanceState.getString("KeyTVL3")
        textView7.text = savedInstanceState.getString("KeyTVL4")
        textView8.text = savedInstanceState.getString("KeyTVL5")
        textView9.text = savedInstanceState.getString("KeyTVL6")
        button3.text = savedInstanceState.getString("KeyBut3Tx")
        button4.text = savedInstanceState.getString("KeyBut4Tx")
        button5.text = savedInstanceState.getString("KeyBut5Tx")
        button6.text = savedInstanceState.getString("KeyBut6Tx")
        button7.text = savedInstanceState.getString("KeyBut7Tx")
        button8.text = savedInstanceState.getString("KeyBut8Tx")
        checkIfButt(textView2)
        flagBud(textView2)
    }

    @Override
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

    private fun timerTick() {
        runOnUiThread(doTask)
    }

    private fun timerTick2() {
        runOnUiThread(doTask2)
    }

    private fun timerTick3() {
        runOnUiThread(doTask3)
    }

    private fun timerTick4() {
        runOnUiThread(doTask4)
    }

    private fun timerTick5() {
        runOnUiThread(doTask5)
    }

    private fun timerTick6() {
        runOnUiThread(doTask6)
    }

    private val doTask = Runnable {
        textView2.setText((parseInt(textView2.text.toString()) + 6).toString())
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        imageView11.startAnimation(wacircAnimation)
        checkIfButt(textView2)
    }
    private val doTask2 = Runnable {
        textView2.setText((parseInt(textView2.text.toString()) + 9).toString())
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        imageView2.startAnimation(wacircAnimation)
        checkIfButt(textView2)
    }
    private val doTask3 = Runnable {
        textView2.setText((parseInt(textView2.text.toString()) + 15).toString())
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        imageView3.startAnimation(wacircAnimation)
        checkIfButt(textView2)
    }
    private val doTask4 = Runnable {
        textView2.setText((parseInt(textView2.text.toString()) + 16).toString())
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        imageView4.startAnimation(wacircAnimation)
        checkIfButt(textView2)
    }
    private val doTask5 = Runnable {
        textView2.setText((parseInt(textView2.text.toString()) + 20).toString())
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        imageView5.startAnimation(wacircAnimation)
        checkIfButt(textView2)
    }
    private val doTask6 = Runnable {
        textView2.setText((parseInt(textView2.text.toString()) + 23).toString())
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        imageView6.startAnimation(wacircAnimation)
        checkIfButt(textView2)
    }
    private lateinit var imageView21: ImageView
    private lateinit var imageView11: ImageView
    private lateinit var imageView31: ImageView
    private lateinit var imageView41: ImageView
    private lateinit var imageView51: ImageView
    private lateinit var imageView61: ImageView
    private lateinit var imageView: ImageView
    private lateinit var imageView2: ImageView //#98FB98
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageView5: ImageView
    private lateinit var imageView6: ImageView
    private lateinit var textView2: TextView
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView9: TextView //star
    private lateinit var textView7: TextView //8
    private lateinit var textView8: TextView //6
    private lateinit var timerTask: TimerTask


    var cost = 4
    var cost2 = 10
    var cost3 = 15
    var cost4 = 20
    var cost5 = 25
    var cost6 = 30

    fun addNum(view: View) {
        addN(view, parseInt(textView3.text.toString()))
        checkIfButt(textView2)
    }

    fun addNum2(view: View) {
        if (flagBud2 == 0) {
            imageView21.setEnabled(false)
        } else {
            addN(imageView2, parseInt(textView4.text.toString()))
        }
        checkIfButt(textView2)
    }

    fun addNum3(view: View) {
        if (flagBud3 == false) {
            imageView31.setEnabled(false)
        } else {
            addN(imageView3, parseInt(textView5.text.toString()))
        }
        checkIfButt(textView2)
    }

    fun addNum4(view: View) {
        if (flagBud4 == false) {
            imageView41.setEnabled(false)
        } else {
            addN(imageView4, parseInt(textView8.text.toString()))
        }
        checkIfButt(textView2)
    }

    fun addNum5(view: View) {
        if (flagBud5 == false) {
            imageView51.setEnabled(false)
        } else {
            addN(imageView5, parseInt(textView7.text.toString()))
        }
        checkIfButt(textView2)
    }

    fun addNum6(view: View) {
        if (flagBud6 == false) {
            imageView61.setEnabled(false)
        } else {
            addN(imageView6, parseInt(textView9.text.toString()))
        }
        checkIfButt(textView2)
    }

    private fun addN(view: View, add1: Int) {
        var count: Int = parseInt(textView2.text.toString())
        count += add1; textView2.text = count.toString()
        val wacircAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.watercirc)
        view.startAnimation(wacircAnimation)
    }

    fun buyUp(view: View) {
        val myTimer = Timer()
        if (textView3.text == "+1" && (parseInt(textView2.text.toString()) - cost) >= 0) {
            upCost(textView3, cost, button3, "+3", "+3", cost)
            cost = 10
            button3.text = concat(button3.text.toString(), cost.toString())
        } else if (textView3.text == "+3" && (parseInt(textView2.text.toString()) - cost) >= 0) {
            upCost(textView3, cost, button3, "+6", "+", cost)
            button3.text = "Auto   cost: 15"
            cost = 15
        } else if (textView3.text == "+6" && (parseInt(textView2.text.toString()) - cost) >= 0) {
            textView2.text = (parseInt(textView2.text.toString()) - cost).toString()
            button3.text = "-0.1    cost: 20"
            cost = 20
            timerTask = object : TimerTask() {
                override fun run() {
                    timerTick()
                }
            }
            myTimer.schedule(timerTask, 1000, 2000)
            setAutoBack(button3)
        }
        checkIfButt(textView2)
    }

    fun buyUp2(view: View) {
        val myTimer = Timer()
        if (button4.text == "     cost: 10" && (parseInt(textView2.text.toString()) - cost2) >= 0) {
            changePal(imageView21, imageView2, "#ABFFAB","#00FF00","#346934", "#14ff82")
            textView2.text = (parseInt(textView2.text.toString()) - cost2).toString()
            button4.text = "+3   cost: 15"
            cost2 = 15
            flagBud2 = 1
        } else if (textView4.text == "+2" && (parseInt(textView2.text.toString()) - cost2) >= 0) {
            upCost(textView4, 5, button4, "+5", "+4", 10)
            cost2 = 20
            button4.text = "+4   cost: 20"
        } else if (textView4.text == "+5" && (parseInt(textView2.text.toString()) - cost2) >= 0) {
            upCost(textView4, 5, button4, "+9", "+", 10)
            cost2 = 25
            button4.text = "Auto   cost: 25"
        } else if (button4.text == "Auto   cost: 25" && (parseInt(textView2.text.toString()) - cost2) >= 0) {
            textView2.text = (parseInt(textView2.text.toString()) - cost2).toString()
            cost2 = 30
            button4.text = "-0.1   cost: 30"
            timerTask = object : TimerTask() {
                override fun run() {
                    timerTick2()
                }
            }
            myTimer.schedule(timerTask, 1000, 2000)
            setAutoBack(button4)
        } else if (button4.text == "-0.1   cost: 30" && (parseInt(textView2.text.toString()) - cost2) >= 0) {
            setDone(button4, cost2)
            cost2 = 0
        }
        checkIfButt(textView2)
    }

    fun buyUp3(view: View) {
        val myTimer = Timer()
        if (button5.text == "     cost: 15" && (parseInt(textView2.text.toString()) - cost3) >= 0) {
            changePal(imageView3, imageView31, "#FBFDAA", "#FFFF00", "#B8B050", "#FEB629")
            textView2.text = (parseInt(textView2.text.toString()) - cost3).toString()
            button5.text = "+5   cost: 20"
            cost3 = 20
            flagBud3 = true
        } else if (textView5.text == "+3" && (parseInt(textView2.text.toString()) - cost3) >= 0) {
            upCost(textView5, 15, button5, "+8", "+7", 10)
            cost3 = 25
            button5.text = "+7   cost: 25"
        } else if (textView5.text == "+8" && (parseInt(textView2.text.toString()) - cost3) >= 0) {
            upCost(textView5, 5, button5, "+15", "+5", 10)
            cost3 = 30
            button5.text = "Auto   cost: 30"
        } else if (button5.text == "Auto   cost: 30" && (parseInt(textView2.text.toString()) - cost3) >= 0) {
            textView2.text = (parseInt(textView2.text.toString()) - 15).toString()
            cost3 = 35
            button5.text = "-0.1   cost: 35"
            timerTask = object : TimerTask() {
                override fun run() {
                    timerTick3()
                }
            }
            myTimer.schedule(timerTask, 1000, 2000)
            setAutoBack(button5)
        }
        checkIfButt(textView2)
    }

    fun buyUp4(view: View) {
        var myTimer = Timer()
        if (button6.text == "     cost: 20" && (parseInt(textView2.text.toString()) - cost4) >= 0) {
            changePal(imageView4, imageView41, "#FFB8FB", "#FF17F2", "#B850B2", "#FE34FF")
            textView2.text = (parseInt(textView2.text.toString()) - 17).toString()
            cost4 = 25
            button6.text = "+6   cost: 25"
            flagBud4 = true
        } else if (textView8.text == "+4" && (parseInt(textView2.text.toString()) - cost4) >= 0) {
            upCost(textView8, 17, button6, "+10", "+7", 10)
            cost4 = 30
            button6.text = "+7   cost: 30"
        } else if (textView8.text == "+10" && (parseInt(textView2.text.toString()) - cost4) >= 0) {
            upCost(textView8, 5, button6, "+17", "+", 10)
            cost4 = 35
            button6.text = "Auto   cost: 35"
        } else if (button6.text == "Auto   cost: 35") {
            textView2.text = (parseInt(textView2.text.toString()) - cost4).toString()
            cost4 = 40
            button6.text = "-0.1   cost: 40"
            timerTask = object : TimerTask() {
                override fun run() {
                    timerTick4()
                }
            }
            myTimer.schedule(timerTask, 1000, 2000)
            setAutoBack(button6)
        }
        checkIfButt(textView2)
    }

    fun buyUp5(view: View) {
        var myTimer = Timer()
        if (button7.text == "     cost: 25" && (parseInt(textView2.text.toString()) - cost5) >= 0) {
            changePal(imageView5, imageView51, "#B7FFFE", "#25FFFC", "#33C6C4", "#16DDFC")
            textView2.text = (parseInt(textView2.text.toString()) - cost5).toString()
            cost5 = 30
            button7.text = "+7   cost: 30"
            flagBud5 = true
        } else if (textView7.text == "+5" && (parseInt(textView2.text.toString()) - cost5) >= 0) {
            upCost(textView7, 15, button7, "+12", "+8", 10)
            cost5 = 35
            button7.text = "+8   cost: 30"
        } else if (textView7.text == "+12" && (parseInt(textView2.text.toString()) - cost5) >= 0) {
            upCost(textView7, 5, button7, "+20", "+", 10)
            cost5 = 40
            button7.text = "Auto   cost: 40"
        } else if (button7.text == "Auto   cost: 40" && (parseInt(textView2.text.toString()) - cost5) >= 0) {
            textView2.text = (parseInt(textView2.text.toString()) - 15).toString()
            cost5 = 45
            button7.text = "-0.1   cost: 45"
            timerTask = object : TimerTask() {
                override fun run() {
                    timerTick5()
                }
            }
            myTimer.schedule(timerTask, 1000, 2000)
            setAutoBack(button7)
        }
        checkIfButt(textView2)
    }

    fun buyUp6(view: View) {
        val myTimer = Timer()
        if (button8.text == "     cost: 30") {
            changePal(imageView6, imageView61, "#FFB79A", "#FF7D23", "#D55D21", "#FD6D6C")
            textView2.text = (parseInt(textView2.text.toString()) - cost6).toString()
            cost6 = 35
            button8.text = "+9   cost: 35"
            flagBud6 = true
        } else if (textView9.text == "+6" && (parseInt(textView2.text.toString()) - cost6) >= 0) {
            upCost(textView9, 15, button8, "+15", "+9", 10)
            cost6 = 40
            button8.text = "+9   cost: 40"
        } else if (textView9.text == "+15" && (parseInt(textView2.text.toString()) - cost6) >= 0) {
            upCost(textView9, 5, button8, "+23", "+", 10)
            cost6 = 45
            button8.text = "Auto   cost: 45"
        } else if (button8.text == "Auto   cost: 45" && (parseInt(textView2.text.toString()) - cost6) >= 0) {
            textView2.text = (parseInt(textView2.text.toString()) - cost6).toString()
            cost6 = 50
            button8.text = "-0.1   cost: 50"
            //timerTask.cancel()
            timerTask = object : TimerTask() {
                override fun run() {
                    timerTick6()
                }
            }
            myTimer.schedule(timerTask, 1000, 2000)
            setAutoBack(button8)
        }
        checkIfButt(textView2)
    }


    fun upCost(
        textView: TextView,
        cost: Int,
        button: Button,
        change: String,
        set: String,
        costE: Int
    ) {
        textView2.text = (parseInt(textView2.text.toString()) - cost).toString()
        button.text = concat(set.toString(), "  cost: ")
        textView.text = change
    }

    fun checkIfButt(view: View) {
        checkIfFun(button3, cost)
        checkIfFun(button4, cost2)
        checkIfFun(button5, cost3)
        checkIfFun(button6, cost4)
        checkIfFun(button7, cost5)
        checkIfFun(button8, cost6)
    }

    fun checkIfFun(button: Button, cost: Int) {
        if (parseInt(textView2.text.toString()) - cost >= 0) {
            button.setEnabled(true)
            button.setTextColor(Color.WHITE)
        } else {
            button.setEnabled(false)
            button.setTextColor(Color.GRAY)
        }
    }

    fun setDone(button: Button, cost: Int) {
        textView2.text = (parseInt(textView2.text.toString()) - cost).toString()
        button.text = "DONE"
    }

    fun flagBud(textView: TextView) {
        if (flagBud2 == 1) {
            imageView21.setColorFilter(Color.argb(1, 1, 1, 1))
        }
        if (flagBud3 == true) {
            imageView31.setColorFilter(Color.argb(1, 1, 1, 1))
        }
        if (flagBud4 == true) {
            imageView41.setColorFilter(Color.argb(1, 1, 1, 1))
        }
        if (flagBud5 == true) {
            imageView51.setColorFilter(Color.argb(1, 1, 1, 1))
        }
        if (flagBud6 == true) {
            imageView61.setColorFilter(Color.argb(1, 1, 1, 1))
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == R.id.nav_profile) {
            //val toast = Toast.makeText(this, "SHARE", Toast.LENGTH_LONG)
            //toast.show()
            val randomInt = Intent(this, ChangePalette::class.java)
            startActivity(randomInt)
            this.finish()
        }
    if (item.getItemId() == R.id.app_bar_switch){
        if (isLightTheme == false) {
            isLightTheme = true
            //item.setIcon(getResources().getDrawable(R.drawable.sun))
        } else if (isLightTheme == true) {
            isLightTheme = false
            //item.setIcon(getResources().getDrawable(R.drawable.baseline_brightness_2_24))
        }
        recreate()
        }
        return true
      }
    fun userLog(view:View){
        val intentGo = Intent(this, UserLogin::class.java)
        startActivity(intentGo)
    }

    override fun onStart(){
        super.onStart()
//        else if(intent.getStringExtra(flagPas) == "1") {
//            if (flagBud2 == 1){
//                imageView21.setColorFilter(Color.parseColor("#00FF00"))
//                imageView2.setColorFilter(Color.parseColor("#00FF00"))
//            }
//            if (flagBud3 == true) {
//                imageView31.setColorFilter(Color.parseColor("#FFFF00"))
//                imageView3.setColorFilter(Color.parseColor("#FFFF00"))
//            }
//        }
//        else if(intent.getStringExtra(flagPas) == "2") {
//            if (flagBud2 == 1){
//                imageView21.setColorFilter(Color.parseColor("#98FB98"))
//                imageView2.setColorFilter(Color.parseColor("#98FB98"))
//            }
//            if (flagBud3 == true) {
//                imageView31.setColorFilter(Color.parseColor("#FFFF00"))
//                imageView3.setColorFilter(Color.parseColor("#FFFF00"))
//            }
//        }
//        else if(intent.getStringExtra(flagPas) == "3") {
//            //Toast.makeText(this, intent.getStringExtra(flagPas), Toast.LENGTH_LONG).show()
//            imageView11.setColorFilter(Color.parseColor("#DCDCDC"))
//            imageView.setColorFilter(Color.parseColor("#DCDCDC"))
//            if (flagBud2 == 1) {
//                imageView21.setColorFilter(Color.parseColor("#006400"))
//                imageView2.setColorFilter(Color.parseColor("#006400"))
//            }
//            if (flagBud3 == true) {
//                imageView31.setColorFilter(Color.parseColor("#BDB76B"))
//                imageView3.setColorFilter(Color.parseColor("#BDB76B"))
//            }
//        }
        if (intent.getStringExtra(flagPas) != null){
            changePal(imageView, imageView11, "#FFFFFF", "#FFFFFF", "#D8D7D4", "#FFFFFF")
        }
        if (flagBud2 == 1){
            changePal(imageView2, imageView21, "#ABFFAB", "#00FF00", "#346934", "#14ff82")
        }
        if (flagBud3 == true){
            changePal(imageView3, imageView31, "#FBFDAA", "#FFFF00", "#B8B050", "#FEB629")
        }
        if (flagBud4 == true){
            changePal(imageView4, imageView41, "#FFB8FB", "#FF17F2", "#B850B2", "#FE34FF")
        }
        if (flagBud5 == true){
            changePal(imageView5, imageView51, "#B7FFFE", "#25FFFC", "#33C6C4", "#16DDFC")
        }
        if (flagBud6 == true){
            changePal(imageView6, imageView61, "#FFB79A", "#FF7D23", "#D55D21", "#FD6D6C")
        }
    }
    fun changePal(imV: ImageView, imV1: ImageView, colP:String, colB: String, colD: String, colR: String) {
        if (intent.getStringExtra(flagPas) == null) {
            imV.setColorFilter(Color.parseColor(colP))
            imV1.setColorFilter(Color.parseColor(colP))
        }
        if (intent.getStringExtra(flagPas) == "1") {
            imV.setColorFilter(Color.parseColor(colP))
            imV1.setColorFilter(Color.parseColor(colP))
        }
        else if (intent.getStringExtra(flagPas) == "2") {
            imV.setColorFilter(Color.parseColor(colB))
            imV1.setColorFilter(Color.parseColor(colB))
        }
        else if (intent.getStringExtra(flagPas) == "3") {
            imV.setColorFilter(Color.parseColor(colD))
            imV1.setColorFilter(Color.parseColor(colD))
        }
        else if (intent.getStringExtra(flagPas) == "4") {
            imV.setColorFilter(Color.parseColor(colR))
            imV1.setColorFilter(Color.parseColor(colR))
        }
    }
    fun setAutoBack(button: Button){
        if (isLightTheme == false) {
            button.setBackgroundDrawable(getResources().getDrawable(R.drawable.auto_button_work))
        } else if (isLightTheme == true) {
            button.setBackgroundDrawable(getResources().getDrawable(R.drawable.auto_button_work_light))
        }

    }

}

