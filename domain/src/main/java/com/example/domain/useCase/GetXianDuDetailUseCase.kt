package com.example.domain.useCase

import com.example.data.net.request.GetXianDuDetailInfoRequest
import com.example.domain.modle.XianDuDetailInfo
import io.reactivex.Observable

/**
 * Created by lilei on 2018/7/16.
 */
class GetXianDuDetailUseCase : BaseUseCase<ArrayList<XianDuDetailInfo>>() {

    var request = GetXianDuDetailInfoRequest()

    fun setAppId(app_id: String) {
        request.app_id = app_id
    }

    fun setCount(count: Int) {
        request.count = count
    }

    fun setPage(page: Int) {
        request.page = page
    }

    override fun getBuildObservable(): Observable<ArrayList<XianDuDetailInfo>> {
        return dataRepositor.getXianDuDetailInfo(request)
    }
}