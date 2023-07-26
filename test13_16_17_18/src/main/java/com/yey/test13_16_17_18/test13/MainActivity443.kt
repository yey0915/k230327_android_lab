package com.yey.test13_16_17_18.test13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.yey.test13_16_17_18.R
import com.yey.test13_16_17_18.databinding.ActivityMain443Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity443 : AppCompatActivity() {
    lateinit var binding: ActivityMain443Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain443Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {


            //무거운 연산을 테스트 CPU를 사용하는 것
            var sum = 0L
            var time = measureTimeMillis {
                for(i in 1..1_000_000_000){
                    sum += i
                }
            }
            Log.d("kkang","time : $time")
            binding.resultView.text = "sum : $sum"

            //해결책1, 핸들러 방식
            //임포트  1) Handler 2) Message 3) Thread
//            val handler=object: Handler(){
//                override fun handleMessage(msg: Message) {
//                    super.handleMessage(msg)
//                    binding.resultView.text = "sum : ${msg.arg1}"
//                }
//            }
//
//            thread {
//                var sum = 0L
//                var time = measureTimeMillis {
//                    for (i in 1..2_000_000_000) {
//                        sum += i
//                    }
//                    val message = Message()
//                    message.arg1=sum.toInt()
//                    handler.sendMessage(message)
//                }
//                Log.d("kkang", "time : $time")
//            }//핸들러 블록 끝부분

            //코루틴 2번) 해결책
            //코루틴 데이터의 결과를 메세지로 전달하는 도구
            val channel = Channel<Int>()

            //코루틴, 스코프(클래스), 를 구성
            //메인 스코프, 백그라운드 스코프
            //백그라운드에서 1) 무거운 연산(CPU 사용하는 작업) : Dispatchers 2) 네트워크, 파일IO
            val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
            //CoroutineScope : 임의로 만든 스코프
            backgroundScope.launch {
                var sum = 0L
                var time = measureTimeMillis {
                    for (i in 1..10_000_000_000) {
                        sum += i
                    }
                }
                Log.d("kkang", "time : $time")
                //메인에 전달함
                channel.send(sum.toInt())
            }

            //시스템 메인 스코프 재사용
            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                //채널 도구를 이용해서 전달된, 데이터를 가져오는 작업
                channel.consumeEach {
                    binding.resultView.text = "sum : $it"
                }
            }//코루틴 마지막 블록
        }//버튼의 클릭 리서너 이벤트 핸들러 닫는 부분
    }
}