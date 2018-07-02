package com.example.domain.repositories

import com.example.data.dataSource.DataManager
import com.example.data.net.response.GetReadingListsResponse
import io.reactivex.Observable

/**
 * Created by lilei on 2018/6/29.
 */
class DataRepositor {
    var dataManager:DataManager = DataManager()

    fun getReadingLists():Observable<GetReadingListsResponse>{
        return dataManager.getReadingListsObservable()
    }
}