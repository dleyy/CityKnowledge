package com.example.data.net.response

import com.example.data.response.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by lilei on 2018/6/29.
 */
open class GetReadingListsResponse : BaseResponse() {


    @SerializedName("error")
    var error: Boolean = false

    @SerializedName("results")
    var list: List<Bean> = ArrayList<Bean>()


    open class Bean() {
        @SerializedName("_id")
        var _id: String = ""

        @SerializedName("en_name")
        var en_name: String = ""

        @SerializedName("name")
        var name: String = ""

        @SerializedName("rank")
        var rank: String = ""
    }
}