package com.yey.exam0725.member

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yey.exam0725.R
import com.yey.exam0725.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    lateinit var binding : ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoin?.setOnClickListener {
            //val intent = Intent
        }
    }
}