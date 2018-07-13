package cityknowledge.cityknowledge.view.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.mvp.contract.ItemRankContract
import cityknowledge.cityknowledge.mvp.present.ItemRankPresent
import com.example.domain.modle.ItemDetailRank
import kotlinx.android.synthetic.main.activity_item_rank.*

/**
 * Created by lilei on 2018/7/13.
 */
class ItemRankListActivity : BaseActivity<ItemRankPresent>(), ItemRankContract.ItemRankView {

    override fun inflateLayout(): Int {
        return R.layout.activity_item_rank
    }

    override fun initDate() {
        item_rank_recycle.setLayoutManager(LinearLayoutManager(this))
    }


    override val present: ItemRankPresent
        get() = ItemRankPresent(this)

    override fun showLoadingDialog() {
        item_rank_recycle.showProgress()
    }

    override fun disMissLoadingDialog() {
        item_rank_recycle.showRecycler()
    }

    override fun handleError(e: Throwable) {
        exceptionHandler.handleException(e)
    }

    override fun showDetailList(list: ArrayList<ItemDetailRank>) {

    }


}