package com.example.data.response

/**
 * Created by lilei on 2018/6/29.
 */
open class BaseResponse {

    var code: String = ""
    var message: String = ""

    fun isSuccess(): Boolean {
        return this.code.equals("200")
    }
}