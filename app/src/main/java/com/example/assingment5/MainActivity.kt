package com.example.assingment5

import android.app.AlertDialog
import android.content.DialogInterface
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
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {
    var count = 0;
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countButton = findViewById<Button>(R.id.Count_button)
        val randomButton = findViewById<Button>(R.id.Random_button)
        val countNumber = findViewById<TextView>(R.id.Count_number)


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


    fun onButton1Clicked(view: View?) {

        val countNumber = findViewById<TextView>(R.id.Count_number)
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