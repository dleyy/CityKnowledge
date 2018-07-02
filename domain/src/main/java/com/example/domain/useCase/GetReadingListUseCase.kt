package com.example.domain.useCase

import com.example.data.net.response.GetReadingListsResponse
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by lilei on 2018/6/29.
 */
class GetReadingListUseCase : BaseUseCase<GetReadingListsResponse>() {

    override fun getBuildObservable(): Observable<GetReadingListsResponse> {
        return dataRepositor.getReadingLists()
    }

}