package cityknowledge.cityknowledge.view.activity

import android.support.v7.app.AppCompatActivity
import cityknowledge.cityknowledge.mvp.IView
import cityknowledge.cityknowledge.mvp.present.BasePresent

/**
 * Created by lilei on 2018/7/6.
 */
abstract class BaseActivity<T:BasePresent> : AppCompatActivity(), IView {

    abstract val present:T

    override fun onDestroy() {
        present.destroyUseCase()
        super.onDestroy()
    }
}