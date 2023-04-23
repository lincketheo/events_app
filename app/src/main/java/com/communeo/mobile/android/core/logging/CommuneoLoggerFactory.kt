package com.communeo.mobile.android.core.logging

import com.communeo.mobile.android.core.logging.impl.AndroidLogger

class CommuneoLoggerFactory {
    companion object {
        fun getLogger(instance: Any): CommuneoLogger {
            return AndroidLogger(instance.javaClass.simpleName)
        }

        fun getLogger(TAG: String): CommuneoLogger {
            return AndroidLogger(TAG)
        }

        fun getLogger(): CommuneoLogger {
            return AndroidLogger("MAIN")
        }
    }
}
