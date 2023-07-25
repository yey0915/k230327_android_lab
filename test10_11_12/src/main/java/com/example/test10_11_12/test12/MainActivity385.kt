package com.example.test10_11_12.test12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.test10_11_12.R
import com.example.test10_11_12.databinding.ActivityMain385Binding
import com.example.test10_11_12.fragment.OneFragment
import com.example.test10_11_12.fragment.ThreeFragment
import com.example.test10_11_12.fragment.TwoFragment
import com.google.android.material.tabs.TabLayout

class MainActivity385 : AppCompatActivity() {
    lateinit var binding : ActivityMain385Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain385Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabs

        //탭 레이아웃과 프래그먼트 연동하는 설정.
        //시작시, 이 영역에 :  R.id.tabContent -> OneFragment
        supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()
        //탭 클릭시 이벤트 핸들러 설정 부분.
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            //탭 버튼 선택시 이벤트
            //탭을 매개변수로 정의했음
            //탭 클릭시, 해당 문자열을 기준으로 조건문 동작
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //트랜잭션이 할당 된 부분은 프래그먼트를 코드 상으로 작업 하겠다는 의미.
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.text){
                    "Tab1"-> transaction.replace(R.id.tabContent, OneFragment())
                    "Tab2"-> transaction.replace(R.id.tabContent, TwoFragment())
                    "Tab3"-> transaction.replace(R.id.tabContent, ThreeFragment())
                }
                //이 부분이 수행이 되어야 동작을 한다.
                transaction.commit()
            }
            //선택된 탭 버튼을 다시 선택하는 경우
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity385, "onTabReselected", Toast.LENGTH_LONG).show()
                Log.d("kkang", "onTabReselected........")
            }
            //선택된 탭버튼이 다른 탭 버튼을 눌러 선택 해제 되는 경우
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity385, "onTabUnselected", Toast.LENGTH_LONG).show()
                Log.d("kkang", "onTabUnselected........")
            }
        })
    }
}