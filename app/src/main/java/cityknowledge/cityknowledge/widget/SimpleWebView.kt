package cityknowledge.cityknowledge.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.CookieSyncManager
import android.webkit.JavascriptInterface
import com.tencent.smtt.sdk.WebViewClient
import android.widget.FrameLayout
import cityknowledge.cityknowledge.R
import cityknowledge.cityknowledge.R.id.web_content
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import kotlinx.android.synthetic.main.view_simple_webview.view.*

/**
 * Created by lilei on 2018/7/16.
 */
class SimpleWebView(context: Context, attri: AttributeSet?) : WebView(context, attri) {

    val maxProgress = 100

    constructor(context: Context) : this(context, null)

    constructor(context: Context, i: Int, b: Boolean) : this(context, null)

    var webView: WebView

    var viewMeasuredHeight = 0

    init {
        val view = View.inflate(context, R.layout.view_simple_webview, this)
        webView = view.findViewById(R.id.web_content)
        progressBar.max = maxProgress
        progressBar.progressDrawable = resources.getDrawable(R.drawable.progress)
        useDefaultSetting(webView.settings)
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(p0: WebView?, p1: Int) {
                if (p1 == 100) {
                    progressBar.visibility = View.GONE
                } else {
                    progressBar.visibility = View.VISIBLE
                    progressBar.progress = p1
                }
            }
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(p0: WebView?, p1: String?) {
                super.onPageFinished(p0, p1)
                WebContent().onGetWenHeight()
            }
        }
    }

    fun loadUrls(url: String) {
        webView.loadUrl(url)
    }

    private fun useDefaultSetting(webSetting: WebSettings) {
        webSetting.allowFileAccess = true
        webSetting.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSetting.setSupportZoom(true)
        webSetting.builtInZoomControls = true
        //webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false)
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true)
        // webSetting.setDatabaseEnabled(true);
        webSetting.domStorageEnabled = true
        webSetting.javaScriptEnabled = true
        webSetting.setGeolocationEnabled(true)
        webSetting.setAppCacheMaxSize(java.lang.Long.MAX_VALUE)
        webSetting.setAppCachePath(context.getDir("appcache", 0).path)
        webSetting.databasePath = context.getDir("databases", 0).path
        webSetting.setGeolocationDatabasePath(context.getDir("geolocation", 0)
                .path)
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.pluginState = WebSettings.PluginState.ON_DEMAND
        CookieSyncManager.createInstance(context)
        CookieSyncManager.getInstance().sync()
    }

    inner class WebContent {
        @JavascriptInterface
        public fun onGetWenHeight() {
            web_content.post(Runnable {
                kotlin.run {
                    web_content.measure(0, 0)
                    viewMeasuredHeight = web_content.measuredHeight
                }
            })
        }
    }
}