package cityknowledge.cityknowledge.mvp.present

import cityknowledge.cityknowledge.mvp.contract.HomeContract
import cityknowledge.cityknowledge.mvp.model.HomeModel
import com.example.domain.DefaultDisposable
import com.example.domain.modle.Article
import com.example.domain.useCase.GetReadingListUseCase
import kotlin.properties.Delegates

/**
 * Created by lilei on 2018/7/9.
 */
open class HomePresent(var view: HomeContract.IHomeView)
    : BasePresent(), HomeContract.IHomePresent {

    val model: HomeModel by lazy { HomeModel() }

    init {

        model.useCase = GetReadingListUseCase()

        model.disposable = object : DefaultDisposable<ArrayList<Article>>() {
            override fun onNext(t: ArrayList<Article>) {
                view.showRank(t)
                view.disMissLoadingDialog()
            }

            override fun onError(e: Throwable) {
                view.handleError(e)
                view.disMissLoadingDialog()
            }
        }

    }

    fun loadData() {
        model.getQuestionList()
    }

    override fun destroyUseCase() {
        model.destroyUseCase()
    }
}