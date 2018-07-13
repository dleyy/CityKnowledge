package cityknowledge.cityknowledge.mvp.model

import com.example.domain.DefaultDisposable
import com.example.domain.modle.ItemDetailRank
import com.example.domain.useCase.GetItemListUseCase

/**
 * Created by lilei on 2018/7/13.
 */
class ItemRankModel : BaseModel<ArrayList<ItemDetailRank>>() {

    fun loadDate() {
        useCase?.execute(disposable)
    }
}