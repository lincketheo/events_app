package com.communeo.mobile.android.features.business.comments.data.source.network.impl

import com.communeo.mobile.android.core.network.CommonKtorDataSource
import com.communeo.mobile.android.core.util.toQueryString
import com.communeo.mobile.android.features.business.comments.data.source.network.RemoteSubCommentDataSource
import com.communeo.mobile.android.features.business.comments.data.source.network.models.SubCommentResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import javax.inject.Inject

class KtorRemoteSubCommentDataSourceImpl @Inject constructor() : RemoteSubCommentDataSource,
    CommonKtorDataSource() {
    override suspend fun getSubCommentsForComment(
        commentId: ULong,
        page: UInt,
        pageSize: UInt
    ): List<SubCommentResponse> {
        val queryParams = mapOf(
            "commentId" to commentId.toString(),
            "page" to page.toString(),
            "pageSize" to pageSize.toString(),
        )

        val url = "$baseUrl/subComments?${queryParams.toQueryString()}"
        return client.get(url).body()
    }
}
