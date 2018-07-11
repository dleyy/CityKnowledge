package cityknowledge.cityknowledge.mvp.present

import cityknowledge.cityknowledge.mvp.IPresent
import cityknowledge.cityknowledge.mvp.IView
import cityknowledge.cityknowledge.mvp.contract.HomeContract
import cityknowledge.cityknowledge.mvp.model.HomeModel
import cityknowledge.cityknowledge.view.activity.MainActivity
import com.example.domain.DefaultDisposable
import com.example.domain.Exception.ExceptionHandler
import com.example.domain.modle.Article

/**
 * Created by lilei on 2018/7/9.
 */
open class HomePresent(var view: HomeContract.IHomeView)
    : BasePresent(),HomeContract.IHomePresent {

    private val model: HomeModel = HomeModel(object : DefaultDisposable<ArrayList<Article>>() {
        override fun onNext(t: ArrayList<Article>) {
            view.showRank(t)
        }

        override fun onError(e: Throwable) {
            view.handleError(e)
        }
    })

    fun loadData() {
        model.getQuestionList()
    }

    override fun destroyUseCase() {
        model.destroyUseCase()
    }
}