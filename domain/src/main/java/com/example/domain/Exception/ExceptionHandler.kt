package com.example.domain.Exception

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.domain.R
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by lilei on 2018/7/2.
 */
class ExceptionHandler(var context: Context) {
    val TAG:String = "Net Error"
    var code: String = ""
    var message: String = ""

    fun handleException(e: Throwable) {
        Log.e(TAG,e.message)
        when (e) {
            is SocketTimeoutException -> {
                toastMessage(context.getString(R.string.socket_time_out))
            }
            is ConnectException -> {
                toastMessage(context.getString(R.string.connect_time_out))
            }
            is UnknownHostException -> {
                toastMessage(context.getString(R.string.host_error))
            }
            else -> {
                toastMessage(context.getString(R.string.other_exception))
            }
        }
    }

    private fun toastMessage(s: String) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
    }
}