package com.example.domain.repositories

import com.example.data.dataSource.DataManager
import com.example.data.net.request.GetReadingListRequest
import com.example.data.net.response.GetReadingListsResponse
import com.example.data.response.BaseResponse
import com.example.domain.modle.Article
import com.example.domain.modle.ItemDetailRank
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by lilei on 2018/6/29.
 */
class DataRepositor {
    private var dataManager: DataManager = DataManager()

    fun getReadingList(request: GetReadingListRequest): Observable<ArrayList<Article>> {
        return dataManager.getReadingListsObservable(request).map { t ->
            val list: ArrayList<Article> = ArrayList()
            t.list.mapTo(list) { Article(it._id, it.name, it.en_name, it.rank) }
            list
        }
    }

    fun getItemList(request: GetReadingListRequest): Observable<ArrayList<ItemDetailRank>> {
        return dataManager.getItemDetailObservable(request).map { t ->
            var list: ArrayList<ItemDetailRank> = ArrayList()
            t.list.mapTo(list) {
                ItemDetailRank(it.createdAt, it.icon,
                        it.id, it.title)
            }
            list
        }
    }
}
