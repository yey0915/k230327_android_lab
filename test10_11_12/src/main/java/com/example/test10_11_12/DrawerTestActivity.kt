package com.example.test10_11_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.test10_11_12.databinding.ActivityDrawerTestBinding

class DrawerTestActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityDrawerTestBinding

        super.onCreate(savedInstanceState)
        binding = ActivityDrawerTestBinding.inflate(layoutInflater)

        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        //액션바를 toggle에 연결, 버튼 클릭시 토글 show
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //이벤트가 toggle 버튼에서 제공된거라면..
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}