package com.example.k230327_android_lab

val data4:Int by lazy{
    println("in lazy.....")
    10
}
val data3:Any = 10



val name : String = "Hong"

lateinit var name2: String
//lateinit var num: Int
// 기본 문법에 대한 설명은 참고 및, 한번 정도
// 직접 코드로 작성해서, 오류 부분 정도 확인하고,
// 그리고 실제 작업은 ide에서 체크 해주니 도움을 받자.


fun main(){
//    val name: String
//    name = "Hong"
//    println("이름은: $name")
//
//    println("hello world")

//    println("==by lazy=================")
//    println("data4 사용하자 : $data4 이 할당")
//    println("is main...................")
//    println("data4 plus : " + data4.plus(10))
//    println("data4 minus : " + data4.minus(5))
//    println("data4 compareTo : " + data4.compareTo(10))
//    println("data4 div : " + data4.div(2))
//    println("data4 equals : " + data4.equals(data3))
//    println(data4 + 10)
//
//    //null 허용할수 있는 연산자가 있을 때만
//    var data6: Int? =2
//    data6 = null
//
//
//    println("==========함수 호출===========")
//    fun some(sum1:Int, sum2:Int =10):Int{
//        return sum1 + sum2
//    }
//    println(some(10))
//    println(some(10, 20))
//
//    println("========================컬렉션 타입==========")
//    //Array, 선언, 세터, 게터
//    val ex01: Array<Int> = Array(3, {0})
//    ex01[0] = 10
//    ex01[1] = 20
//    ex01.set(2, 30)
//    println("""
//        ex01의 사이즈 : ${ex01.size}
//        ex01의 data : ${ex01.get(0)}
//        ex01의 요소 : ${ex01[0]}, ${ex01[1]}, ${ex01[2]}
//
//    """.trimIndent())
//
//    println("=========반복문===========================")
//    var sum :Int = 0
//    for(i in 0..2){
//        sum += ex01[i]
//    }
//    println("반복문을 사용한 합계 :  ${sum}")
//
//    println("========클래스=============================")
//
//    val user = User("홍길동", 20)


    val result = hofFun({no -> no > 0})
    println(result())


}

fun hofFun(arg: (Int) -> Boolean): () -> String {
    val result = if(arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}

class Test {
    val data4: Int = 30
}

class User(name : String, age : Int){
    init {
        println("name : $name, age : ${age}")
    }
}