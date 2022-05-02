package com.example.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countButton = findViewById<Button>(R.id.Count_button)
        val randomButton = findViewById<Button>(R.id.Random_button)
        var countNumber = findViewById<TextView>(R.id.Count_number)
        var count = 0;

        countButton.setOnClickListener{
            count++
            countNumber.setText(count.toString())
        }

        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK){
                val receive = it.data?.getIntExtra("카운트", -1) ?:""
                count = receive.toString().toInt()
                countNumber.setText(receive.toString())
            }
        }

        randomButton.setOnClickListener {
            val intent = Intent(applicationContext, SubActivity::class.java)
                intent.putExtra("카운트", count)
                activityResultLauncher.launch(intent)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    fun onButton1Clicked(v: View?){
        Toast.makeText(this, "안녕! 내가 누군지 물어본다면 나는 식빵", Toast.LENGTH_SHORT).show();
    }
}