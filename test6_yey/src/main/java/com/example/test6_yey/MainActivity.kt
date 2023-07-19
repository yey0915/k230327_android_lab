package com.example.test6_yey

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test6_yey.databinding.ActivityMainBinding


//AppCompatActivity() : 상속 받은 클래스가 시스템 컴포넌트로 바뀐다.
//액티비티 : 화면에 그리는 역할
class MainActivity : AppCompatActivity() {
    var status : Int = 0
    //onCreate : 최초에 한번 화면에 출력을 하는 역할
    override fun onCreate(savedInstanceState: Bundle?) {


        //뷰바인딩 적용1
        //ActivityMainBinding : 시스템에서 바인딩해준다.
        //여기 코드, 설정 코드이기때문에, 디비 연결하는 Connection 객체 용도가 비슷
        val binding = ActivityMainBinding.inflate(layoutInflater)

        //savedInstanceState: Bundle? -> 임시 데이터 저장 객체
        super.onCreate(savedInstanceState)
        //레이아웃 샘플로 리니어 사용하는 중, 이유? 제약 조건 설정이 간단
        //뷰만 선택해서 배치만하면, 기본 세로, 가로방향으로 배치가 간단

        //뷰바인딩2
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        //버튼 클릭 -> 이미지 -> show / hide
        //버튼에 이벤트 클릭 리스너 설정 후 -> 결과로 이미지의 속성 중에
        //visibility 속성으로 show / hide 테스트
        //binding 객체 안에, 사용하는 뷰의 모든 객체가 다 담아져 있습니다.
        binding.btn1.setOnClickListener {
            binding.img1.visibility = View.GONE
        }
        binding.btn2.setOnClickListener{
            binding.img1.visibility = View.VISIBLE
        }

        binding.btn0.setOnClickListener {
            if(status == 0){
                binding.img1.visibility = View.GONE
                status = 1
            }else{
                binding.img1.visibility = View.VISIBLE
                status = 0
            }

            println("status 값 확인 $status")
        }


        //버튼 하나로 토글처럼(스위치) => 상태 패턴, 상태 나타내는 변수를 하나 지정


        //회원가입 버튼 클릭시 해당 액티비티 화면이동
        binding.btnJoin.setOnClickListener {
            // 인텐트 라는 개념에 가장 기초인 화면 전환
            val intent = Intent(this@MainActivity, JoinActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val id : String = binding.idInput.text.toString()
            val pwd : String = binding.pwdInput.text.toString()
            Log.d("hiesa", "id값은 : $id, pwd값은 : $pwd")
            Toast.makeText(this@MainActivity, "id의 값 : $id, pw의 값 : $pwd", Toast.LENGTH_SHORT).show()
        }

    }
}