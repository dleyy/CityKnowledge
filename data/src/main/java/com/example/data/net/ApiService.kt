package com.example.data.net

import com.example.data.net.response.GetReadingListsResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by lilei on 2018/6/28.
 */
interface ApiService{

    companion object {
        val baseUrl:String = "http://gank.io/api/"
    }

    @GET("xiandu/categories")
    fun testBaiduInterface(): Observable<GetReadingListsResponse>
}