package cityknowledge.cityknowledge.mvp.present

import android.icu.lang.UScript
import android.util.Log
import cityknowledge.cityknowledge.mvp.contract.ItemDetailListContract
import cityknowledge.cityknowledge.mvp.model.ItemDetailModel
import com.example.domain.DefaultDisposable
import com.example.domain.modle.XianDuDetailInfo
import com.example.domain.useCase.GetXianDuDetailUseCase

/**
 * Created by lilei on 2018/7/16.
 */
class ItemDetailPresent(var view: ItemDetailListContract.ItemDetailListView)
    : BasePresent(), ItemDetailListContract.ItemDetailListPresent {

    private val model = ItemDetailModel()

    private val useCase = GetXianDuDetailUseCase()

    init {
        model.useCase = useCase
        model.disposable = object : DefaultDisposable<ArrayList<XianDuDetailInfo>>() {
            override fun onNext(t: ArrayList<XianDuDetailInfo>) {
                view.showDetail(t)
                view.disMissLoadingDialog()
                Log.e("OK","success"+t.size);
            }

            override fun onError(e: Throwable) {
                view.handleError(e)
                view.disMissLoadingDialog()
                Log.e("OK","success"+e.message);
            }
        }
    }

    fun loadDate(appId: String, count: Int = 10, page: Int = 1) {
        view.showLoadingDialog()
        useCase.setAppId(appId)
        useCase.setCount(count)
        useCase.setPage(page)
        model.useCase = useCase
        model.loadDate()
    }

    override fun destroyUseCase() {
        useCase.unSubscribe()
    }
}