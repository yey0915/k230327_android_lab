package com.example.test10_11_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test10_11_12.databinding.ActivityDetailBinding
import com.example.test10_11_12.databinding.ActivityNoti2Binding

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}