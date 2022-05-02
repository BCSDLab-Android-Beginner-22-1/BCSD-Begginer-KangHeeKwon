package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        var RandomNumber = findViewById<TextView>(R.id.Random_number)
        var Talktext = findViewById<TextView>(R.id.Talk_text)
        val random = Random()

        val intent = Intent(applicationContext, MainActivity::class.java).apply{
            var count2 = intent.getIntExtra("카운트", -1)
            Talktext.setText("여기있다\n무작위 숫자\n 사이\n 0과 $count2")
            count2 = random.nextInt(count2 + 1)
            RandomNumber.setText(count2.toString())
            putExtra("카운트",count2)
        }
        setResult(RESULT_OK, intent)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}