package cityknowledge.cityknowledge.widget

import android.app.Dialog
import android.content.Context

/**
 * Created by lilei on 2018/6/26.
 */
class CommonDialog (context:Context):Dialog(context){

    fun notice(message:String,tag: String = javaClass.simpleName){
        System.out.println(tag+" "+message)
    }
}