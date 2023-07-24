package com.example.test10_11_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.test10_11_12.databinding.ActivityFragTestBinding
import com.example.test10_11_12.fragment.OneFragment
import com.example.test10_11_12.fragment.TwoFragment

class FragTestActivity : AppCompatActivity() {
    lateinit var binding : ActivityFragTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //프래그먼트 기본 테스트,
        //경로 : MainActivity337.kt
        //1) xml로 구성, 2) 코드로 구성하는 방법
        //방법1) xml로 구성하는 방법

        //방법2) 액티비티 코드로 만들기
        //TwoFragment 만들어서 구현중

        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        //뷰 페이지와 탭 메뉴 등을 구현할 때 사용한다
        val fragment = OneFragment()
        transaction.add(R.id.fragment_content, fragment)

        //백스탭을 설정시 커밋 이전 함수에서 설정 가능
        //뒤로가기 버튼을 클릭시 해당 액티비티를 종료하는게 아니라\
        //메모리상에 있는 프래그먼트를 재사용
        //옵션 설정이 없으면,
        transaction.addToBackStack(null)
        transaction.commit()

    }
}