package com.example.test10_11_12

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test10_11_12.databinding.ActivityViewPager2FragmentBinding
import com.example.test10_11_12.databinding.Item354Binding
import com.example.test10_11_12.fragment.OneFragment
import com.example.test10_11_12.fragment.ThreeFragment
import com.example.test10_11_12.fragment.TwoFragment

class ViewPager2_Fragment_Activity : AppCompatActivity() {

    lateinit var binding: ActivityViewPager2FragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPager2FragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //뷰페이저2 구현 - 프래그먼트 방식으로 연결
        //프래그먼트 구현 방법1) xml 태그 출력, 방법2) 액티비티 코드상 출력
        //355,
        val datas = mutableListOf<String>()
        for(i in 1..3){
            datas.add("Item $i")
        }
        val adapter= MyFragmentPagerAdapter(this)
        binding.viewpager.adapter = adapter
    }

    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init {
            fragments= listOf(OneFragment(), TwoFragment(), ThreeFragment())
            Log.d("kkang" ,"fragments size : ${fragments.size}")
        }
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment = fragments[position]
    }


}