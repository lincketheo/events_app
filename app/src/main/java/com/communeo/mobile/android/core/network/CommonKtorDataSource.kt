package com.communeo.mobile.android.core.network

import com.communeo.mobile.android.CommuneoApplication
import com.communeo.mobile.android.R
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

open class CommonKtorDataSource {
    protected val baseUrl = CommuneoApplication.resources.getString(R.string.base_url)
    protected val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }
}
