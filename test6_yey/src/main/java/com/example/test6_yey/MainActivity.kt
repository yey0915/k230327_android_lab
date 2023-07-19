package com.example.test6_yey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//AppCompatActivity() : 상속 받은 클래스가 시스템 컴포넌트로 바뀐다.
//액티비티 : 화면에 그리는 역할
class MainActivity : AppCompatActivity() {
    //onCreate : 최초에 한번 화면에 출력을 하는 역할
    override fun onCreate(savedInstanceState: Bundle?) {
        //savedInstanceState: Bundle? -> 임시 데이터 저장 객체
        super.onCreate(savedInstanceState)
        //레이아웃 샘플로 리니어 사용하는 중, 이유? 제약 조건 설정이 간단
        //뷰만 선택해서 배치만하면, 기본 세로, 가로방향으로 배치가 간단
        setContentView(R.layout.activity_main)
    }
}