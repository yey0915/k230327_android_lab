package com.yey.test13_16_17_18.test13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.yey.test13_16_17_18.R
import com.yey.test13_16_17_18.databinding.ActivityMain406Binding
import com.yey.test13_16_17_18.databinding.ActivityMain408Binding

class MainActivity408 : AppCompatActivity() {

    lateinit var binding: ActivityMain408Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain408Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //후처리 결과는 동일, 과정은 상이
        //사용 권고 함수
        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            //시스템에서 제공을 해주고 있음.
            //pdf 11/56
            //StartActivityForResult
            //TakePicture : 사진 촬용, 저장, 비트맴 획득
            ActivityResultContracts.StartActivityForResult())
        {
            //it : 후처리의 결과 객체.
            val result = it.data?.getStringExtra("resultData")
            binding.mainResultView.text = "resultData : $result"
        }

        binding.button1.setOnClickListener {

            val intent: Intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data1", "hello")
            intent.putExtra("data2", 10)
            //후처리 함수 호출 , 메인 -> 디테일 화면으로
            //디테일 화면에서 데이터를 잘 설정해서 되돌려주면
            //상단에 정의된
            //registerForActivityResult
            //콜백 함수의 결과 처리장에서 작업
            requestLauncher.launch(intent)
        }
    }
}