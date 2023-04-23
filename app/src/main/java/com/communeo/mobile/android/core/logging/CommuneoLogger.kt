package com.communeo.mobile.android.core.logging

interface CommuneoLogger {
    fun debug(msg: String, throwable: Throwable? = null)
    fun info(msg: String, throwable: Throwable? = null)
    fun warn(msg: String, throwable: Throwable? = null)
    fun error(msg: String, throwable: Throwable? = null)
}
