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

    fun getReadingLists(): Observable<GetReadingListsResponse> {
        return dataManager.getReadingListsObservable()
    }

    fun getReadingList(): Observable<ArrayList<Article>> {
        return dataManager.getReadingListsObservable().map(object :
                Function<GetReadingListsResponse, ArrayList<Article>> {
            override fun apply(t: GetReadingListsResponse): ArrayList<Article> {
                var list: ArrayList<Article> = ArrayList()
                for (re in t.list) {
                    list.add(Article(re._id, re.name, re.en_name, re.rank))
                }
                return list
            }
        })
    }
}
