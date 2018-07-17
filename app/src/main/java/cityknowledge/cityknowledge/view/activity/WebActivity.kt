package cityknowledge.cityknowledge.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import cityknowledge.cityknowledge.Constants
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.widget.SimpleWebView
import kotlinx.android.synthetic.main.activity_web_activity.*
import kotlin.properties.Delegates

/**
 * Created by lilei on 2018/7/17.
 */
class WebActivity : AppCompatActivity() {

    var simpleWeb: SimpleWebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_activity)
        simpleWeb = findViewById(R.id.simple_webView)

        simpleWeb?.loadUrls(intent.getStringExtra(Constants.KEY_DETAIL_URLS))
    }
}