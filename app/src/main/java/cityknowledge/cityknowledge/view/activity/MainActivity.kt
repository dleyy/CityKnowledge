package cityknowledge.cityknowledge.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.adapter.KnowledgeListAdapter
import com.example.domain.DefaultDisposable
import com.example.domain.Exception.ExceptionHandler
import com.example.domain.modle.Article
import com.example.domain.useCase.GetReadingListUseCase

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var getReadingListUseCase: GetReadingListUseCase = GetReadingListUseCase()

    private val recycleAdapter = KnowledgeListAdapter(this,
            { })

    private val exceptionHandler = ExceptionHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recycle.layoutManager = LinearLayoutManager(this)

        my_recycle.adapter = recycleAdapter
        getReadingListUseCase.execute(object : DefaultDisposable<ArrayList<Article>>() {
            override fun onError(e: Throwable) {
                exceptionHandler.handleException(e)
            }

            override fun onComplete() {
            }

            override fun onNext(t: ArrayList<Article>) {
                recycleAdapter.setData(t)
            }
        })
    }

    override fun onDestroy() {
        getReadingListUseCase.unSubscribe()
        super.onDestroy()
    }
}
