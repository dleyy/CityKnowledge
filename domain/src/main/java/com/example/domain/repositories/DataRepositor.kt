package com.example.domain.repositories

import com.example.data.dataSource.DataManager
import com.example.data.net.response.GetReadingListsResponse
import com.example.data.response.BaseResponse
import com.example.domain.modle.Article
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by lilei on 2018/6/29.
 */
class DataRepositor {
    var dataManager: DataManager = DataManager()

    fun getReadingList(): Observable<ArrayList<Article>> {
        return dataManager.getReadingListsObservable().map { t ->
            var list: ArrayList<Article> = ArrayList()
            t.list.mapTo(list) { Article(it._id, it.name, it.en_name, it.rank) }
            list
        }
    }

}
