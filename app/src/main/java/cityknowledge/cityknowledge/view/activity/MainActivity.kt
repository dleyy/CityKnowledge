package cityknowledge.cityknowledge.view.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.adapter.KnowledgeListAdapter
import cityknowledge.cityknowledge.mvp.contract.HomeContract
import cityknowledge.cityknowledge.mvp.present.HomePresent
import com.example.domain.Exception.ExceptionHandler
import com.example.domain.modle.Article

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity<HomePresent>(), HomeContract.IHomeView {
    override val present: HomePresent
        get() = HomePresent(this)

    private val recycleAdapter = KnowledgeListAdapter(this,
            { -> })

    private val exceptionHandler = ExceptionHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycle.setLayoutManager(LinearLayoutManager(this))

        my_recycle.adapter = recycleAdapter

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

}
