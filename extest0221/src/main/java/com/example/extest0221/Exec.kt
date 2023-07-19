package com.example.extest0221

import android.service.autofill.UserData
import java.util.Scanner

data class UserData(val id:String, val pwd:String, val email:String, val phone:String ){}
fun main(){

    val sc: Scanner = Scanner(System.`in`)

    //클래스에 만들어서 사용할 때 , 주 생성자를 이용하는데,
    // 매개변수 부분에 변수 앞에 val 라는 키워드를 사용해서, 전역으로 사용하는 부분

    for (i in 1..3){
        print("아이디를 입력하세요 : ")
        val id : String = sc.nextLine()
        //println("입력한 아이디는 $id")
        print("pwd를 입력하세요 : ")
        val pwd : String = sc.nextLine()
        print("email를 입력하세요 : ")
        val email : String = sc.nextLine()
        print("phone를 입력하세요 : ")
        val phone : String = sc.nextLine()

        //val userlist : UserData = UserData(id, pwd, email, phone)
    }
    
//로그인 함수(맴버 입력, 회원목록){
//      맴버 == 회원목록 이면 로그인 성공
// }

//    println("로그인 하기 : ID, PWD를 입력하자")
//    print("ID : ")
//    val chId = sc.nextLine()
//    print("PWD : ")
//    val chpwd = sc.nextLine()
//
//    if(chId == id && chpwd == pwd){
//        println("로그인 성공")
//        println("$id / $pwd")
//    }else{
//        println("로그인 실패")
//    }



    //id = readLine()!!.toString()


}

/*class LoginTest {
    companion object{
        //클래스 함수 -> 클래스명.함수
        fun login(user : UserData){
            if(user.id.equals("admin") && user.pwd.equals("1234")){
                println("로그인 성공")
            }else{
                println("로그인 실패")
            }

        }
    }
}*/