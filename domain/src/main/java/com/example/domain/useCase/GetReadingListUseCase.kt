package com.example.domain.useCase

import com.example.data.net.request.GetReadingListRequest
import com.example.data.net.response.GetReadingListsResponse
import com.example.domain.modle.Article
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by lilei on 2018/6/29.
 */
class GetReadingListUseCase : BaseUseCase<ArrayList<Article>>() {

    var getReadingListRequest: GetReadingListRequest = GetReadingListRequest()

    fun setEnName(enName: String) {
        getReadingListRequest.enName = enName
    }

    override fun getBuildObservable(): Observable<ArrayList<Article>> {
        return dataRepositor.getReadingList(getReadingListRequest)
    }
}