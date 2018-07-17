package com.example.data.net.request

import com.example.data.request.BaseRequest

/**
 * Created by lilei on 2018/7/16.
 */
class GetXianDuDetailInfoRequest() : BaseRequest() {
    var app_id: String = ""
    var count: Int = 10
    var page: Int = 1
}