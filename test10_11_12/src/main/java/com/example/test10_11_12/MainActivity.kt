package com.example.test10_11_12

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.test10_11_12.databinding.ActivityMainBinding
import com.example.test10_11_12.databinding.DialogSampleBinding

class MainActivity : AppCompatActivity() {
    //binding 사용, 1) build.gradle(설정, sync now)
    lateinit var binding : ActivityMainBinding

    //최초 1회에 한번 실행이 되는 함수, 특징 : 매개변수로 번들 타입의 객체를 가짐
    //번들 타입의 객체 : 메모리상에 임시 저장하는 파일
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate -> 인스턴스화를 한다. -> 객체 생성한다.
        binding = ActivityMainBinding.inflate(layoutInflater)
        //binding.root : activity_main 의 메인 layer에 binding
        setContentView(binding.root)



        //테스트1, 권한 관련
        //인텐트 할 때, 후처리 방법에서 더 설명.
        //인텐트 기본 기능
        //1) 액티비티 간의 전환(화면 이동)
        //2) 화면 간의 이동시, 데이터 전달하는 함수
        //3) 화면 이동 하고, 이동 된 화면에서 작업 후 데이터 원래 화면에 가져오는 역할.
        //예) A 앱, 갤러리(외부 앱) 접근해서, 사진을 선택 후, 다시 A 앱 가져오는 경우
        //예) A 앱, 외부앱 접근해서 권한을 획득하고, 다시 A앱으로 돌아오는 경우
        //4) 외부(시스템 해당 앱에 접근시) intent-filter -> 명시적으로 설정.
//        val requestPermissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestPermission()
//        ) { isGranted ->
//
//            if (isGranted) {
//                Log.d("kkang", "callback, granted..")
//            } else {
//                Log.d("kkang", "callback, denied..")
//            }
//        }

//        val status= ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
//        if(status == PackageManager.PERMISSION_GRANTED){
//            Log.d("kkang", "granted..")
//        }else {
//            requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
//        }

        //테스트2 토스트 추가 옵션 확인
        //showToast()

        //테스트3 날짜 다이얼로그, 시간 다이얼로그 확인
        //279
        binding.button1.setOnClickListener {
            DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Log.d("kkang", "year : $p1, month : ${p2+1}, dayOfMonth : $p3")
                    //뷰에 출력해도 된다.
                    binding.dateView.text = "year : $p1, month : ${p2+1}, dayOfMonth : $p3"
                }
            }, 2023, 6, 21).show()
        }
        binding.button2.setOnClickListener {
            TimePickerDialog(this, object: TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Log.d("kkang", "time : $p1, minute : $p2")
                    binding.timeView.text = "시간 : $p1, 분 : ${p2+1}"
                }
            }, 15, 0, true).show()
        }


        //테스트4, 알림 다이얼로그1
        binding.button3.setOnClickListener {
            //경고창 뜬 이류 : import 가 2개이므로 선택하기
            //androidx를 선택
            AlertDialog.Builder(this).run {
                setTitle("test dialog")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("정말 종료하시겠습니까?")
                //eventHandler 정의한 부분 복사 필요
                setPositiveButton("OK", eventHandler)
                setNegativeButton("Cancel", eventHandler)
                show()
            }
        }


        binding.button4.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(
                    items,
                    object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            Toast.makeText(this@MainActivity, "선택한 과일 : ${items[p1]}}", Toast.LENGTH_LONG).show()
                            binding.fruitView.text = "${items[p1]}"
                            Log.d(
                                "kkang",
                                "선택한 과일 : ${items[p1]}}"
                            )
                        }
                    })
                setPositiveButton("닫기", null)
                show()
            }
        }

        binding.button5.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "수박", "딸기")
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true, false, true, false),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int, p2: Boolean) {
                            Log.d(
                                "kkang",
                                "${items[p1]} 이 ${if (p2) "선택되었습니다." else "선택 해제되었습니다."}"
                            )
                        }
                    })
                setPositiveButton("닫기", null)
                show()
            }
        }

        binding.button6.setOnClickListener {
            val dialogBinding = DialogSampleBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("Input")
                setView(dialogBinding.root)
                setPositiveButton("닫기", null)
                show()
            }
        }
    }//end onCreate

    // 이벤트 처리시 익명 함수를 많이 사용
    // 알림의 다이얼로그 부분에서, 예 또는 아니오 선택시
    // 추가 작업을 설정하는 이벤트 핸들러
    val eventHandler = object : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            if (p1 == DialogInterface.BUTTON_POSITIVE) {
                Log.d("kkang", "positive button click")
                Toast.makeText(this@MainActivity, "positive button click", Toast.LENGTH_LONG).show()
            } else if (p1 == DialogInterface.BUTTON_NEGATIVE) {
                Log.d("kkang", "negative button click")
                Toast.makeText(this@MainActivity, "negative button click", Toast.LENGTH_LONG).show()

            }
        }
    }//end eventHandler

    //함수정리
    //테스트2, 토스트 추가 옵션, 보이고 나서 추가 작업, 사라지고 나서 추가작업
    @RequiresApi(Build.VERSION_CODES.R)
    fun showToast() {
        val toast = Toast.makeText(this, "종료하려면 한 번 더 누르세요.", Toast.LENGTH_LONG)
        toast.addCallback(
            object : Toast.Callback() {
                override fun onToastHidden() {
                    super.onToastHidden()
                    Log.d("kkang", "toast hidden")
                }
                override fun onToastShown() {
                    super.onToastShown()
                    Log.d("kkang", "toast shown")
                }
            })
        toast.show()
    }//end showToast

}