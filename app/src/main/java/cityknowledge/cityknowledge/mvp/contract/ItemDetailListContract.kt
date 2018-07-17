package cityknowledge.cityknowledge.mvp.contract

import cityknowledge.cityknowledge.mvp.IPresent
import cityknowledge.cityknowledge.mvp.IView
import com.example.domain.modle.XianDuDetailInfo

/**
 * Created by lilei on 2018/7/16.
 */
interface ItemDetailListContract {
    interface ItemDetailListView:IView{
        fun showDetail(list: ArrayList<XianDuDetailInfo>)
    }

    interface ItemDetailListPresent:IPresent{

    }
}