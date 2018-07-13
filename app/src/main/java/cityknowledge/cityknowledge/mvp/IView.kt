package cityknowledge.cityknowledge.mvp

/**
 * Created by lilei on 2018/7/6.
 */
interface IView {

    fun showLoadingDialog()

    fun disMissLoadingDialog()

    fun handleError(e: Throwable)

}