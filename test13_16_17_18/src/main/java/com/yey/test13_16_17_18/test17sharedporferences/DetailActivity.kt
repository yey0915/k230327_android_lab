package com.yey.test13_16_17_18.test17sharedporferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yey.test13_16_17_18.databinding.ActivityDetail3Binding


class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetail3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("kkang","DetailActivity..onCreate..........")
        binding = ActivityDetail3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //공유 프리퍼런스로 데이터 가져오기
        val pref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        val resultStr2 : String? = pref.getString("data3","값이 없으면 내가 지정됨")
        val result3 = resultStr2.toString()

        binding.detailResultView.text = "result3 : $result3"

        binding.detailButton.setOnClickListener {
            intent.putExtra("resultData", "world")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}