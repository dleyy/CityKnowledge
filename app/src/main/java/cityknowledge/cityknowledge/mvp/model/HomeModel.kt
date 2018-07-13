package cityknowledge.cityknowledge.mvp.model

import com.example.domain.DefaultDisposable
import com.example.domain.modle.Article
import com.example.domain.useCase.GetReadingListUseCase

/**
 * Created by lilei on 2018/7/9.
 */
class HomeModel : BaseModel<ArrayList<Article>>() {

    fun getQuestionList() {
        useCase?.execute(disposable)
    }

}