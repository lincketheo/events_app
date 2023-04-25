package com.communeo.mobile.android.core.util

fun Map<String, String>.toQueryString(): String {
    return map { "${it.key}=${it.value}" }.joinToString("&")
}
