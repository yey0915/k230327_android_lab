package com.example.test10_11_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.test10_11_12.databinding.ActivityJetBinding

class JetActivity : AppCompatActivity() {
    lateinit var binding : ActivityJetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바 직접 만들기
        setSupportActionBar(binding.toolbar)


    }


    //액션바(테마사용) -> 툴바로 대체 할 예정 기초
    //메뉴 구성방법 1) 코드로 2) xml 구성하는 방식(현재 작업중...)

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //화면에 출력하기 위한 객체 생성(인스턴스)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu1 -> {
            Toast.makeText(this@JetActivity, "0 클릭됨", Toast.LENGTH_LONG).show()
            Log.d("kkang", "menu1 click")
            true
        }
        R.id.menu2 -> {
            Toast.makeText(this@JetActivity, "1 클릭됨", Toast.LENGTH_LONG).show()
            Log.d("kkang", "menu2 click")
            true
        }
        R.id.menu3 -> {
            Toast.makeText(this@JetActivity, "2 클릭됨", Toast.LENGTH_LONG).show()
            Log.d("kkang", "menu2 click")
            true
        }
        R.id.add1 -> {
            Toast.makeText(this@JetActivity, "3 클릭됨", Toast.LENGTH_LONG).show()
            Log.d("kkang", "menu2 click")
            true
        }
        R.id.search1 -> {
            Toast.makeText(this@JetActivity, "4 클릭됨", Toast.LENGTH_LONG).show()
            Log.d("kkang", "menu2 click")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}