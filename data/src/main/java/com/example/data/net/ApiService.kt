package com.example.data.net

import com.example.data.net.response.GetReadingListsResponse
import com.example.data.net.response.GetXianDuDetailInfoResponse
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

    @GET("xiandu/categories")
    fun getRankList(): Observable<GetReadingListsResponse>

    @GET("xiandu/category/{en_name}")
    fun getItemRank(@Path("en_name") enName: String): Observable<GetReadingListsResponse>

    @GET("xiandu/data/id/{app_id}/count/{count}/page/{page} ")
    fun getXianDuDetailInfo(@Path("app_id") app_id: String,
                            @Path("count") count: Int,
                            @Path("page") page: Int
    ): Observable<GetXianDuDetailInfoResponse>
}