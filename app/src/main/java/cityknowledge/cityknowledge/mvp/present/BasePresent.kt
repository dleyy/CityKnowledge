package cityknowledge.cityknowledge.mvp.present

import cityknowledge.cityknowledge.mvp.IPresent
import cityknowledge.cityknowledge.mvp.IView


/**
 * Created by lilei on 2018/7/6.
 */
open class BasePresent<T : IView> : IPresent<T> {

    val v: T? = null

}
