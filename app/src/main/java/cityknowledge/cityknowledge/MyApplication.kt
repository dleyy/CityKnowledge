package cityknowledge.cityknowledge

import android.app.Application
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by lilei on 2018/7/4.
 */
class MyApplication : Application() {

    companion object {
        var instance:Application by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}