package com.example.data.net.response

import com.example.data.response.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by lilei on 2018/7/16.
 */
class GetXianDuDetailInfoResponse : BaseResponse() {

    @SerializedName("error")
    var error: Boolean = false

    @SerializedName("results")
    var result = ArrayList<DetailInfo>()

    class DetailInfo {

        @SerializedName("_id")
        var id: String = ""

        var title: String = ""

        var uid: String = ""

        var url: String = ""

        //首页图
        var cover: String = ""

        @SerializedName("site")
        var site = SiteClass()

        class SiteClass {

            /**
            "cat_cn":"趣味软件/游戏",
            "cat_en":"apps",
            "desc":"分享免费、小巧、实用、有趣、绿色的软件",
            "feed_id":"feed/http://feed.appinn.com/",
            "icon":"http://ww3.sinaimg.cn/large/0066P23Wjw1f7efqelrh4j30300300si.jpg",
            "id":"appinn",
            "name":"小众软件",
            "subscribers":43451,
            "type":"rss",
            "url":"http://www.appinn.com"
             **/

            var cat_cn: String = ""

            var cat_en: String = ""

            var desc: String = ""

            var feed_id: String = ""

            var icon: String = ""

            var id: String = ""

            var name: String = ""

            var subscribers: String = ""

            var type: String = ""

            var url: String = ""
        }
    }
}