package cityknowledge.cityknowledge

import android.content.Context
import android.view.View

/**
 * Created by lilei on 2018/7/3.
 */
class ViewExtensions {
    val View.ctx:Context
        get() = context
}