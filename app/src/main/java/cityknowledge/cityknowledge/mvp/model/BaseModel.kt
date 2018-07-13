package cityknowledge.cityknowledge.mvp.model

import cityknowledge.cityknowledge.mvp.IModel
import com.example.domain.DefaultDisposable
import com.example.domain.useCase.BaseUseCase
import io.reactivex.observers.DisposableObserver

/**
 * Created by lilei on 2018/7/6.
 */
abstract class BaseModel<T>() : IModel {

    var disposable = DefaultDisposable<T>()

    var useCase: BaseUseCase<T>? = null

    override fun destroyUseCase() {
        useCase?.unSubscribe()
    }
}