package com.example.assingment5

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class MainActivity : AppCompatActivity(){
    var count = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countButton = findViewById<Button>(R.id.Count_button)
        val randomButton = findViewById<Button>(R.id.Random_button)
        val toastButton = findViewById<Button>(R.id.Toast_Button)
        val countNumber = findViewById<TextView>(R.id.Count_number)
        countButton.setOnClickListener{
            count++
            countNumber.setText(count.toString())
        }

        randomButton.setOnClickListener{
            val fragment_sub = SubFragment()
            val bundle = Bundle()
            bundle.putInt("num", count)
            fragment_sub.arguments = bundle
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_main, fragment_sub)
                .commit()
        }

        toastButton.setOnClickListener{
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("경고 대화 상자!").setMessage("클릭해라!")
            builder.setPositiveButton("긍정",
                DialogInterface.OnClickListener { dialog, id ->
                    count=0
                    countNumber.setText(count.toString())})
            builder.setNegativeButton("자연",
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(
                        applicationContext,
                        "자연 클릭",
                        Toast.LENGTH_SHORT
                    ).show()
                })
            builder.setNeutralButton("부정",
                DialogInterface.OnClickListener { dialog, id ->})
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}