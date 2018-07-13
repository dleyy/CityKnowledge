package cityknowledge.cityknowledge.mvp.contract

import cityknowledge.cityknowledge.mvp.IPresent
import cityknowledge.cityknowledge.mvp.IView
import com.example.domain.modle.ItemDetailRank

/**
 * Created by lilei on 2018/7/13.
 */
interface ItemRankContract {
    interface ItemRankView : IView {
        fun showDetailList(list: ArrayList<ItemDetailRank>)
    }

    interface ItemRankPresent : IPresent {

    }
}