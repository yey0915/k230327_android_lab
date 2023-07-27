package com.yey.test13_16_17_18.test17sharedporferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yey.test13_16_17_18.databinding.ActivityMain7Binding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            //sharedPreference
            val sharedPref = getSharedPreferences("my_prefs",Context.MODE_PRIVATE)
            sharedPref.edit().run {
                putString("data3", "누구의 프리퍼런스인가")
                putInt("data2", 10)
                commit()
            }

            //::class.java 클래스 래퍼런스 타입으로 전달은 보통, 내부 앱에서 전달하는 방식
            val intent: Intent = Intent(this, DetailActivity::class.java)
            //Map 처럼 키와 value의 형태로 데이터를 설정 및 가져오기 작업을 할 예정
//            intent.putExtra("data1", "hello")
//            intent.putExtra("data2", 10)
            //시스템에게 설정한 인텐트를 전달함
            startActivity(intent)
        }

    }
}