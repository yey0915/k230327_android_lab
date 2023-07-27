package com.yey.test13_16_17_18.test16multiImg

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yey.test13_16_17_18.R
import com.yey.test13_16_17_18.databinding.ActivityMain5Binding
import com.yey.test13_16_17_18.databinding.ActivityMain6Binding

//경로
// https://github.com/lsy3709/K230201AndroidLab/tree/master/test16-2multiimg
//
// MainActivity -> 경로 :test16-2multiimg/src/main/java/com/example/test16_2multiimg/MainActivity.kt
// 변경사항 :
// 1 기존 : ActivityMainBinding -> ActivityMain5Binding
// 2 MainActivity 뷰에서
// 속성값-> tools:context=".test16multiImg.MainActivity">
// 3 MultiImageItemBinding : 이미지를 리사이클러 뷰로 출력하기 위한, 목록 아이템 요소의 뷰.
// 4 경로 test16-2multiimg/src/main/res/layout/multi_image_item.xml
// 5 glide : 18장 소개 할 예정. 간단히, 이미지를 출력해주는 도구(코루틴 적용, 비동기식처리)
// 6 많이 사용하는 도구이다. 설정 할려면, build.gradle 모듈 파일에서, 디펜던시 추가하면 됨.
// 7 경로 -> test16-2multiimg/build.gradle
// 필요한 내용은 맨 아래에 디펜더시 안에 있음.
//  implementation 'com.github.bumptech.glide:glide:4.12.0'
// 매니페스트에 액티비트 exported true 변경.

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMain6Binding
    // 갤러리에서 선택된 이미지의 주소를 하나의 객체해서 리스트에 담기.
    var list = ArrayList<Uri>()
    // 리사이클러 뷰에서, 데이터와 뷰를 연결 시키기 위한 하나의 변환기.
//    var adapter = MultiImageAdapter(list,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
    }
}