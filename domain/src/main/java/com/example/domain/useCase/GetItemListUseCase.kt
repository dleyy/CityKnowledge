package com.example.domain.useCase

import com.example.data.net.request.GetReadingListRequest
import com.example.domain.modle.ItemDetailRank
import io.reactivex.Observable

/**
 * Created by lilei on 2018/7/13.
 */
class GetItemListUseCase : BaseUseCase<ArrayList<ItemDetailRank>>() {

    var getReadingListRequest: GetReadingListRequest

    init {
        getReadingListRequest = GetReadingListRequest()
    }

    fun setEnName(enName: String) {
        getReadingListRequest.enName = enName
    }

    override fun getBuildObservable(): Observable<ArrayList<ItemDetailRank>> {
        return dataRepositor.getItemList(getReadingListRequest)
    }
}