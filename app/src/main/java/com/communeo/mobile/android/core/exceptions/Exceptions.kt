package com.communeo.mobile.android.core.exceptions

import com.communeo.mobile.android.CommuneoApplication
import com.communeo.mobile.android.R

open class CommuneoException(
    message: String? = null,
    cause: Throwable? = null,
) : Exception(message, cause) {
    override fun getLocalizedMessage(): String {
        return CommuneoApplication.resources.getString(R.string.something_went_wrong)
    }
}

/**
 * Thrown when a sign in attempt failed
 */
class InvalidSignInException(
    message: String? = null,
    cause: Throwable? = null,
) : CommuneoException(message, cause) {
    override fun getLocalizedMessage(): String {
        return CommuneoApplication.resources.getString(R.string.there_was_a_problem_signing_in)
    }
}
