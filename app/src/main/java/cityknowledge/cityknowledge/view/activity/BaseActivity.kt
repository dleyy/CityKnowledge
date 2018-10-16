package cityknowledge.cityknowledge.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cityknowledge.cityknowledge.mvp.IView
import cityknowledge.cityknowledge.mvp.present.BasePresent
import com.example.domain.Exception.ExceptionHandler

/**
 * Created by lilei on 2018/7/6.
 */
abstract class BaseActivity<T:BasePresent> : AppCompatActivity(), IView {

    abstract val present:T

    abstract fun inflateLayout():Int

    abstract fun initDate()

    val exceptionHandler = ExceptionHandler(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeLoad()
        setContentView(inflateLayout())

        initDate()
    }

   open fun beforeLoad(){

    }

    override fun onDestroy() {
        present.destroyUseCase()
        super.onDestroy()
    }
}