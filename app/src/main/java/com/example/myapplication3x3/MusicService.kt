package com.example.myapplication3x3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.IBinder
import android.provider.MediaStore
import android.support.v4.media.session.MediaControllerCompat
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.myapplication3x3.MusicAdapter

class MusicService : Service() {
    lateinit var mp : MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val musicListUri = intent!!.getStringExtra("Id")
        mp = MediaPlayer.create(this, Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, musicListUri))
        mp.isLooping = false
        mp.start()

        val notificationIntent = Intent(this,MainActivity::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0)

        val notification = NotificationCompat.Builder(this, "default").apply {
            val notificationArtist = intent.getStringExtra("Artist")
            val notificationTitle = intent.getStringExtra("Title")
            setContentTitle("$notificationArtist")
            setContentText("$notificationTitle")
            setSmallIcon(R.drawable.ic_launcher_background)
            setContentIntent(pendingIntent) // 알림 클릭 시 메인액티비티로 돌아옴
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val manager : NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(NotificationChannel("default","기본 채널",NotificationManager.IMPORTANCE_LOW))
        }
        startForeground(1,notification.build())
        return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
        mp.stop()
    }
}

