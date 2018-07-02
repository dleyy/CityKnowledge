package com.example.data.dataSource

import com.example.data.net.ApiService
import com.example.data.net.response.GetReadingListsResponse
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by lilei on 2018/6/29.
 */
class DataManager {

    val apiServices: ApiService

    init {
        apiServices = createApiServices()
    }

    private fun createApiServices(): ApiService {
        var client: OkHttpClient = createClientBuilder().build()
        var retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        retrofitBuilder.baseUrl(ApiService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
        return retrofitBuilder.build().create(ApiService::class.java);
    }

    private fun createClientBuilder(): OkHttpClient.Builder {
        var builder: OkHttpClient.Builder = OkHttpClient.Builder()
        var loginInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        loginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        builder.readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(loginInterceptor)
        return builder
    }

    fun getReadingListsObservable(): Observable<GetReadingListsResponse> {
        return apiServices.testBaiduInterface()
    }

}