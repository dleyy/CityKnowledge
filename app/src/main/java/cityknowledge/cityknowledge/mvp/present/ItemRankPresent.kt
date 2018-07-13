package cityknowledge.cityknowledge.mvp.present

import cityknowledge.cityknowledge.mvp.contract.ItemRankContract
import cityknowledge.cityknowledge.mvp.model.BaseModel
import cityknowledge.cityknowledge.mvp.model.ItemRankModel
import com.example.domain.DefaultDisposable
import com.example.domain.modle.ItemDetailRank
import com.example.domain.useCase.GetItemListUseCase

/**
 * Created by lilei on 2018/7/13.
 */
class ItemRankPresent(var view: ItemRankContract.ItemRankView)
    : BasePresent(), ItemRankContract.ItemRankPresent {

    val model = ItemRankModel()
    val useCase = GetItemListUseCase()

    init {
        model.disposable = object : DefaultDisposable<ArrayList<ItemDetailRank>>() {
            override fun onNext(t: ArrayList<ItemDetailRank>) {
                view.showDetailList(t)
            }

            override fun onError(e: Throwable) {
                view.handleError(e)
            }
        }
    }

    fun loadDate(enName: String) {
        useCase.setEnName(enName)
        model.useCase = useCase
        model.loadDate()
    }

    override fun destroyUseCase() {
        model.destroyUseCase()
    }

}