package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {

    companion object {
        private const val CHANNEL_ID = "testChannel01"
    }
    private var notificationManager: NotificationManager? = null
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var count = 0;
        val countButton = findViewById<Button>(R.id.count_button)
        val randomButton = findViewById<Button>(R.id.random_button)
        val countNumber = findViewById<TextView>(R.id.count_number)



        countButton.setOnClickListener{
            count++
            countNumber.text = count.toString()
        }

        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK){
                val receive = it.data?.getIntExtra("카운트", -1) ?:""
                count = receive.toString().toInt()
                countNumber.text = receive.toString()
            }
        }

        createNotificationChannel(CHANNEL_ID, "testChannel", "this is a test Channel")

        randomButton.setOnClickListener {
            displayNotification(count, CHANNEL_ID)
        }
    }

    fun onButton1Clicked(v: View?){
        Toast.makeText(this, "안녕! 내가 누군지 물어본다면 나는 식빵", Toast.LENGTH_SHORT).show();
    }


    private fun displayNotification(count : Int, channelId: String) {
        val notificationId = 45
        val intent = Intent(this, SubActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        intent.putExtra("카운트", count)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val bulilder= NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.title))
            .setContentText(getString(R.string.content))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, bulilder.build())
        }

    }

    private fun createNotificationChannel(channelId: String, name: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = channelDescription
            }
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager?.createNotificationChannel(channel)
        }
    }

}