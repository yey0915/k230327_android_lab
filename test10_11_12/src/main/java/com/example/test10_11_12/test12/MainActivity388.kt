package com.example.test10_11_12.test12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test10_11_12.R
import com.example.test10_11_12.ViewPager2_Fragment_Activity
import com.example.test10_11_12.databinding.ActivityMain388Binding
import com.example.test10_11_12.fragment.OneFragment
import com.example.test10_11_12.fragment.ThreeFragment
import com.example.test10_11_12.fragment.TwoFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity388 : AppCompatActivity() {
    lateinit var binding : ActivityMain388Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain388Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabs
        val viewPager = binding.viewpager

        viewPager.adapter= MyFragmentPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab${(position + 1)}"
        }.attach()
    }

    //공통 액티비티 코드를 리펙토링을 할 경우 : 아래 매개변수 영역의 액티비티 타입으로 선언하는 방식 사용
    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        //클래스 초기화(객체 생성) 후 실행되는 코드
        init {
            fragments= listOf(OneFragment(), TwoFragment(), ThreeFragment())
        }
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}