package com.communeo.mobile.android.util

import android.content.Context
import androidx.test.core.app.ApplicationProvider

open class BaseInstrumentedTest {
    protected fun getStringResource(id: Int, vararg formatArgs: String): String {
        return getApplicationContext().resources.getString(id, *formatArgs)
    }

    protected fun getApplicationContext(): Context {
        return ApplicationProvider.getApplicationContext()
    }
}
