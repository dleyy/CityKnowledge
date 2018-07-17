package cityknowledge.cityknowledge.view.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import cityknowledge.cityknowledge.Constants
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.adapter.XianDuDetailListAdapter
import cityknowledge.cityknowledge.mvp.contract.ItemDetailListContract
import cityknowledge.cityknowledge.mvp.present.ItemDetailPresent
import com.example.domain.modle.XianDuDetailInfo
import com.jude.easyrecyclerview.decoration.DividerDecoration
import kotlinx.android.synthetic.main.activity_xian_du_item_list.*

/**
 * Created by lilei on 2018/7/16.
 */
class XianDuListActivity : BaseActivity<ItemDetailPresent>(), ItemDetailListContract.ItemDetailListView {

    private var page = 1

    private var count = 10

    private val adapter = XianDuDetailListAdapter(this)

    override val present: ItemDetailPresent
        get() = ItemDetailPresent(this)

    override fun inflateLayout(): Int {
        return R.layout.activity_xian_du_item_list
    }

    override fun initDate() {
        adapter.setMore(R.layout.view_more) {
            page++
            loadData()
        }

        adapter.setOnItemClickListener { position ->
            var intent = Intent()
            intent.putExtra(Constants.KEY_DETAIL_URLS,
                    adapter.allData[position].url)
            intent.setClass(this, WebActivity::class.java)
            startActivity(intent)
        }

        xian_du_list.setLayoutManager(LinearLayoutManager(this))
        xian_du_list.addItemDecoration(DividerDecoration(R.color.gary, 1))
        xian_du_list.setAdapterWithProgress(adapter)
        xian_du_list.setRefreshListener { loadData() }
        loadData()

    }

    override fun showLoadingDialog() {
        xian_du_list.showProgress()
    }

    override fun disMissLoadingDialog() {
        xian_du_list.showRecycler()
    }

    override fun handleError(e: Throwable) {
        exceptionHandler.handleException(e)
    }

    override fun showDetail(list: ArrayList<XianDuDetailInfo>) {
        adapter.addAll(list)
    }

    private fun loadData(app_id: String = intent.getStringExtra(Constants.KEY_APP_ID)) {
        present.loadDate(app_id, count, page)
    }

}