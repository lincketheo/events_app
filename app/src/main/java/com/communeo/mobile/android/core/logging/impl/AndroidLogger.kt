package com.communeo.mobile.android.core.logging.impl

import android.util.Log
import com.communeo.mobile.android.core.logging.CommuneoLogger

class AndroidLogger(private val TAG: String) : CommuneoLogger {
    override fun debug(msg: String, throwable: Throwable?) {
        Log.d(TAG, msg, throwable)
    }

    override fun info(msg: String, throwable: Throwable?) {
        Log.i(TAG, msg, throwable)
    }

    override fun warn(msg: String, throwable: Throwable?) {
        Log.w(TAG, msg, throwable)
    }

    override fun error(msg: String, throwable: Throwable?) {
        Log.e(TAG, msg, throwable)
    }
}
