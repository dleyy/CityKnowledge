package cityknowledge.cityknowledge.mvp.contract

import cityknowledge.cityknowledge.mvp.IPresent
import cityknowledge.cityknowledge.mvp.IView
import com.example.domain.modle.Article

/**
 * Created by lilei on 2018/7/9.
 */
interface HomeContract {
    interface IHomeView : IView {

        fun showRank(list: ArrayList<Article>)

    }

    interface IHomePresent : IPresent {

    }
}