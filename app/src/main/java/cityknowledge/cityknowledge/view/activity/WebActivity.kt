package cityknowledge.cityknowledge.view.activity

import android.content.ClipboardManager
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
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
        val url = intent.getStringExtra(Constants.KEY_DETAIL_URLS)
        simpleWeb?.loadUrls(url)

        copy.setOnClickListener { _ ->
            try {

                val manager: ClipboardManager =
                        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                manager.text = url
                Toast.makeText(this, resources.getString(R.string.copy_success), Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, resources.getString(R.string.copy_fail), Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onBackPressed() {
        if (simpleWeb!!.webView.canGoBack()) {
            simpleWeb!!.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}