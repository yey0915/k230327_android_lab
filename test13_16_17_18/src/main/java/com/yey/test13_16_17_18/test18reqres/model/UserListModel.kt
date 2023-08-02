package com.yey.test13_16_17_18.test18reqres.model

import com.google.gson.annotations.SerializedName

data class UserListModel(

    //실제로 http://reqres.in
    //파라미터 요구사항 명세서
    //이름을 그대로 사용하면 됨
    //주의사항 : 공공데이터의 모델링의 구조를 잘 파악해야함
    var page: String,
    @SerializedName("per_page")
    var perPage: String,
    var total: String,
    @SerializedName("total_pages")
    var totalPages: String,

    // 실제 데이터 모델를 리스트 타입으로 제너릭으로해서 명시한다.
    var data: List<UserModel>?
)
