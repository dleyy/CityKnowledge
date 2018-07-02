package com.example.domain.useCase

import com.example.data.net.response.GetReadingListsResponse
import com.example.domain.modle.Article
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by lilei on 2018/6/29.
 */
class GetReadingListUseCase : BaseUseCase<ArrayList<Article>>() {
    override fun getBuildObservable(): Observable<ArrayList<Article>> {
        return dataRepositor.getReadingList()
    }
}