package cityknowledge.cityknowledge.mvp.model

import com.example.domain.modle.XianDuDetailInfo

/**
 * Created by lilei on 2018/7/16.
 */
class ItemDetailModel : BaseModel<ArrayList<XianDuDetailInfo>>() {

    fun loadDate() {
        useCase?.execute(disposable)
    }
}