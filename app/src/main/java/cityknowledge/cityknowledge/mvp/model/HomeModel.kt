package cityknowledge.cityknowledge.mvp.model

import com.example.domain.DefaultDisposable
import com.example.domain.modle.Article
import com.example.domain.useCase.GetReadingListUseCase

/**
 * Created by lilei on 2018/7/9.
 */
class HomeModel(var disposable: DefaultDisposable<ArrayList<Article>>) : BaseModel() {

    private val getQuestionListUseCase: GetReadingListUseCase by lazy {
        GetReadingListUseCase()
    }

    fun getQuestionList() {
        getQuestionListUseCase.execute(disposable)
    }

    override fun destroyUseCase() {
        getQuestionListUseCase.unSubscribe()
    }
}