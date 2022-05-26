package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class SubActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val randomNumber = findViewById<TextView>(R.id.random_number)
        val talkText = findViewById<TextView>(R.id.talk_text)
        val random = Random()

        val intent = Intent(applicationContext, MainActivity::class.java).apply{
            var count2 = intent.getIntExtra("카운트", -1)
            talkText.setText(getString(R.string.sub_text) + "$count2")
            count2 = random.nextInt(count2 + 1)
            randomNumber.text = count2.toString()
            putExtra("카운트",count2)
        }
        setResult(RESULT_OK, intent)
    }
}