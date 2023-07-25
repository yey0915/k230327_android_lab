package com.example.test10_11_12.test12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test10_11_12.R
import com.example.test10_11_12.databinding.ActivityMain378Binding
import com.example.test10_11_12.databinding.ActivityMain384Binding
import com.google.android.material.tabs.TabLayout


class MainActivity384 : AppCompatActivity() {

    lateinit var binding : ActivityMain384Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain384Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabs

        val tab1: TabLayout.Tab = tabLayout.newTab()
        tab1.text="Tab1"
        tabLayout.addTab(tab1)

        val tab2: TabLayout.Tab = tabLayout.newTab()
        tab2.text="Tab2"
        tabLayout.addTab(tab2)

        val tab3: TabLayout.Tab = tabLayout.newTab()
        tab3.text="Tab3"
        tabLayout.addTab(tab3)
    }
}