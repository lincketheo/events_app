package com.communeo.mobile.android.core.logging.impl

import com.communeo.mobile.android.core.logging.CommuneoLogger
import io.github.aakira.napier.Napier

class NapierLogger(private val TAG: String) : CommuneoLogger {
    override fun debug(msg: String, throwable: Throwable?) {
        Napier.d(tag = TAG, throwable = throwable) { msg }
    }

    override fun info(msg: String, throwable: Throwable?) {
        Napier.i(tag = TAG, throwable = throwable) { msg }
    }

    override fun warn(msg: String, throwable: Throwable?) {
        Napier.w(tag = TAG, throwable = throwable) { msg }
    }

    override fun error(msg: String, throwable: Throwable?) {
        Napier.e(tag = TAG, throwable = throwable) { msg }
    }
}
