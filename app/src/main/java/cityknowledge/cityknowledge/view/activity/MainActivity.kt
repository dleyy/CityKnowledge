package cityknowledge.cityknowledge.view.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.Toast
import cityknowledge.cityknowledge.Constants
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.adapter.KnowledgeListAdapter
import cityknowledge.cityknowledge.mvp.contract.HomeContract
import cityknowledge.cityknowledge.mvp.present.HomePresent
import com.example.domain.modle.Article

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity<HomePresent>(), HomeContract.IHomeView {
    override val present: HomePresent
        get() = HomePresent(this)

    private val recycleAdapter = KnowledgeListAdapter(this
    ) { it ->
        val intent = Intent()
        intent.putExtra(Constants.KEY_ITEM_NAME, it.enName)
        intent.setClass(this, ItemRankListActivity::class.java)
        startActivity(intent)
    }

    private fun loadData() {
        recycleAdapter.cleanAllData()
        my_recycle.showProgress()
        present.loadData()
    }

    override fun showRank(list: ArrayList<Article>) {
        recycleAdapter.addData(list)
    }

    override fun showLoadingDialog() {
        my_recycle.showProgress()
    }

    override fun disMissLoadingDialog() {
        my_recycle.showRecycler()
    }

    override fun handleError(e: Throwable) {
        exceptionHandler.handleException(e)
    }

    override fun inflateLayout(): Int {
        return R.layout.activity_main
    }

    override fun beforeLoad() {

    }

    override fun initDate() {

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val togger = ActionBarDrawerToggle(this, drawerLayout, toolbar,
                0, 0)
        drawerLayout.setDrawerListener(togger)
        togger.syncState()

        leftMenu.setNavigationItemSelectedListener { it ->
            var id = it.itemId
            when (id) {
                R.id.history -> Toast.makeText(this, "history", Toast.LENGTH_SHORT).show()
            }

            true
        }

        my_recycle.setLayoutManager(LinearLayoutManager(this))

        my_recycle.adapter = recycleAdapter

        my_recycle.setRefreshListener {
            loadData()
        }

        loadData()
    }

}
