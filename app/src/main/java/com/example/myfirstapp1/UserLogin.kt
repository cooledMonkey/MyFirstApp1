package com.example.myfirstapp1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp1.databinding.ActivityMainBinding
import com.example.myfirstapp1.databinding.ActivitySecondBinding
import com.example.myfirstapp1.databinding.UserLoginBinding

var flag = 0
var flagSingUp = 1
var regFlag = "1"

class UserLogin: AppCompatActivity(){
    lateinit var binding: UserLoginBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val db = MainDB.getDB(this)
        binding = UserLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button10.setOnClickListener{
            if (binding.textInputEditText.text.toString() == "" || binding.editTextTextPassword.text.toString() == ""){
                Toast.makeText(this, "Try again, looser", Toast.LENGTH_LONG).show()
            }
            else {
                Thread {
                    if (db.getDao().getUser(binding.textInputEditText.text.toString(), binding.editTextTextPassword.text.toString()) == null){
                        flagSingUp = 0
                    }
                }.start()
                if (flagSingUp == 1) {
                    Thread {
                        val item = Item(
                            db.getDao().lastId(), binding.textInputEditText.text.toString(),
                            binding.editTextTextPassword.text.toString()
                        )
                        db.getDao().insertItem(item)
                    }.start()
                    Toast.makeText(this, "Great!", Toast.LENGTH_LONG).show()
                    flagSingUp = 0
                }
                else{
                    Toast.makeText(this, "You are already registered!", Toast.LENGTH_LONG).show()
                    flagSingUp = 1
                }
            }
        }


        binding.button9.setOnClickListener{
            if (binding.textInputEditText.text.toString() == "" || binding.editTextTextPassword.text.toString() == ""){
                Toast.makeText(this, "Try again, looser", Toast.LENGTH_LONG).show()
            }
            else {
                Thread {
                    if (db.getDao().getUser(binding.textInputEditText.text.toString(), binding.editTextTextPassword.text.toString()) != null){
                        flag = 1
                    }
                }.start()
                if(flag == 1){
                Toast.makeText(this, "Great!", Toast.LENGTH_LONG).show()
                    flag = 0
                    val backInt = Intent(this, SecondActivity::class.java)
                    Thread{
                        regFlag = db.getDao().getUserId(binding.textInputEditText.text.toString(), binding.editTextTextPassword.text.toString()).toString()
                        backInt.putExtra(SecondActivity.regFlag, regFlag)
                        startActivity(backInt)
                    }.start()
                }
                else{
                    //Toast.makeText(this, "Such user does not exist!", Toast.LENGTH_SHORT).show()
                    //Toast.makeText(this, "Check your username and password", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}