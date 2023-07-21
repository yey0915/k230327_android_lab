package com.example.test10_11_12

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.test10_11_12.databinding.ActivityNoti2Binding

class NotiActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityNoti2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoti2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //알림설정, 기본1
        //경로
        binding.button.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    // 알림 소리, 알림의 중요도 옵션에 따라 알림음 여부가 결정되고,
                    // 현재 기본이 silent로 선택이 되어서, 디폴트 알림음으로 변경하면
                    // 알림음 확인
                    NotificationManager.IMPORTANCE_LOW
                )
                //채널에 다양한 정보 설정
                channel.description = "My Channel One Description"
                channel.setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                // 알림음 재생
                channel.setSound(uri, audioAttributes)
                // 불빛이 표시된다면 불빛의 표시 여부
                channel.enableLights(true)
                // 불빛이 표시된다면 불빛의 색상
                channel.lightColor = Color.RED
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(100, 200, 100, 200)
                //채널을 NotificationManager에 등록
                manager.createNotificationChannel(channel)

                //채널을 이용하여 builder 생성
                builder = NotificationCompat.Builder(this, channelId)
            } else {
                builder = NotificationCompat.Builder(this)
            }

            builder.setSmallIcon(R.drawable.ic_launcher_foreground)
            builder.setWhen(System.currentTimeMillis())
            // FCM(Firebase Cloud Message), 사용자, 시스템에서 전달된 메시지를 대신 전달해주는 역할
            builder.setContentTitle("Content Title")
            builder.setContentText("Content Massage")

            val intent = Intent(this, DetailActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 10, intent,
                    PendingIntent.FLAG_IMMUTABLE)
            builder.setContentIntent(pendingIntent)
            builder.setAutoCancel(true)

            //오류 : 1차 문법 체크, API 13이상을 쓴다면, 매니페스트에 권한 설정을 해주세요.
            //시스템에서 제공해주는 액션으로 처리했고,

            manager.notify(11, builder.build())
        }

    }
}