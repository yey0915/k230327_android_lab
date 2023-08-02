package com.yey.test13_16_17_18.test18reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yey.test13_16_17_18.R
import com.yey.test13_16_17_18.databinding.ActivityMain3Binding
import com.yey.test13_16_17_18.databinding.ActivityMain9Binding
import com.yey.test13_16_17_18.test18reqres.adapter.MyAdapter
import com.yey.test13_16_17_18.test18reqres.model.UserListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {

    lateinit var binding: ActivityMain9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //시스템에 등록된 설정 관련된 파일 applicationContext
        //MainAcitivity -> MyApplication -> INetworkSerivce
        val networkService = (applicationContext as MyApplication).networkService

        //공공데이터 파라미터 변경 부분.
        //http://apis.data.go.kr/6260000/FoodService/getFoodKr?resultType=json&serviceKey=ALRX9GpugtvHxcIO%2FiPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH%2FAKv%2BA1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ%3D%3D&numOfRows=10&pageNo=1
        //userListCall 의 타입은 Call<UserListModel>
        val userListCall = networkService.doGetUserList(
            "2",)
        Log.d("lsy", "url:" + userListCall.request().url().toString())

        //실제 네트워크 통신의 시작
        userListCall.enqueue(object : Callback<UserListModel> {
            //성공시
            override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                //받은 데이터를 로그캣으로만 출력한 부분
                val userList = response.body()
                Log.d("lsy","Test18 userList data 값 : ${userList?.data}")
                //.......................................

                //데이터를 어댑터에 연결해서, 리사이클러뷰레 출력하는 코드
                //레스트 서버로부터 바은 데이터를 어댑터에 전달. userList?.data
                binding.recyclerView.adapter= MyAdapter(this@MainActivity3, userList?.data)
                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(this@MainActivity3, LinearLayoutManager.VERTICAL)
                )

                binding.pageView.text=userList?.page
                binding.totalView.text=userList?.total
            }

            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                call.cancel()
            }
        })

        binding.testButton.setOnClickListener {
//            val call: Call<UserModel> = networkService.test1()//https://reqres.in/users/list?sort=desc

//            val call: Call<UserModel> = networkService.test2("10", "lsy")//https://reqres.in/group/10/users/lsy

//            val call: Call<UserModel> = networkService.test3("age", "lsy")//https://reqres.in/group/users?sort=age&name=lsy

//            val call: Call<UserModel> = networkService.test4(
//                mapOf<String, String>("one" to "hello", "two" to "world"),
//                "lsy"
//            )//https://reqres.in/group/users?one=hello&two=world&name=lsy

//            val call: Call<UserModel> = networkService.test5(
//                UserModel(id="1", firstName = "gildong", lastName = "hong", avatar = "some url"),
//                "lsy"
//            )//https://reqres.in/group/users?name=lsy

//            val call: Call<UserModel> = networkService.test6(
//                "gildong 길동",
//                "hong 홍",
//                "lsy"
//            )//https://reqres.in/user/edit?name=lsy

//            val list: MutableList<String> = ArrayList()
//            list.add("홍길동")
//            list.add("류현진")
//            val call = networkService.test7(list)

//            val call = networkService.test9("http://www.google.com", "lsy")//http://www.google.com/?name=lsy
//
//            Log.d("lsy","url:"+call.request().url().toString())

        }
    }
}