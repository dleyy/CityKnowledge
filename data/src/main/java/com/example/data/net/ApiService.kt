package com.example.data.net

import com.example.data.net.response.GetReadingListsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by lilei on 2018/6/28.
 */
interface ApiService {

    companion object {
        val baseUrl: String = "http://gank.io/api/"
    }

    @GET("xiandu/categories/{en_name}")
    fun getItemRank(@Path("en_name") enName: String): Observable<GetReadingListsResponse>

    @GET("xiandu/categories")
    fun getRankList(): Observable<GetReadingListsResponse>


}