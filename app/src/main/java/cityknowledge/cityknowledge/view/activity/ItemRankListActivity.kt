package cityknowledge.cityknowledge.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import cityknowledge.cityknowledge.Constants
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.adapter.ItemDetailAdapter
import cityknowledge.cityknowledge.mvp.contract.ItemRankContract
import cityknowledge.cityknowledge.mvp.present.ItemRankPresent
import com.example.domain.modle.ItemDetailRank
import com.jude.easyrecyclerview.decoration.DividerDecoration
import com.jude.easyrecyclerview.swipe.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_item_rank.*

/**
 * Created by lilei on 2018/7/13.
 */
class ItemRankListActivity : BaseActivity<ItemRankPresent>(), ItemRankContract.ItemRankView {

    private val adapter: ItemDetailAdapter = ItemDetailAdapter(this)

    override fun inflateLayout(): Int {
        return R.layout.activity_item_rank
    }

    override fun initDate() {
        adapter.setOnItemClickListener { position: Int ->
            var intent = Intent()
            intent.setClass(this, XianDuListActivity::class.java)
            intent.putExtra(Constants.KEY_APP_ID, adapter.allData[position].id)
            startActivity(intent)
        }

        item_rank_recycle.setLayoutManager(LinearLayoutManager(this))
        item_rank_recycle.setAdapterWithProgress(adapter)
        item_rank_recycle.addItemDecoration(DividerDecoration(R.color.gary, 1))
        item_rank_recycle.setRefreshListener {
            adapter.removeAll()
            loadDate()
        }

        loadDate()
    }

    private fun loadDate() {
        present.loadDate(intent.getStringExtra(Constants.KEY_ITEM_NAME))

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
        adapter.addAll(list)
    }

}