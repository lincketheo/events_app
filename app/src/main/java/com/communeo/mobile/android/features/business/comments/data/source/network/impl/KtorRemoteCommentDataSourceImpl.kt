package com.communeo.mobile.android.features.business.comments.data.source.network.impl

import com.communeo.mobile.android.core.network.CommonKtorDataSource
import com.communeo.mobile.android.core.util.toQueryString
import com.communeo.mobile.android.features.business.comments.data.source.network.RemoteCommentDataSource
import com.communeo.mobile.android.features.business.comments.data.source.network.models.CommentResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class KtorRemoteCommentDataSourceImpl @Inject constructor() : RemoteCommentDataSource,
    CommonKtorDataSource() {
    override suspend fun getCommentsForEvent(
        eventId: ULong,
        page: UInt,
        pageSize: UInt
    ): List<CommentResponse> {
        val queryParams = mapOf(
            "eventId" to eventId.toString(),
            "page" to page.toString(),
            "pageSize" to pageSize.toString(),
        )

        val url = "$baseUrl/comments?${queryParams.toQueryString()}"
        return client.get(url).body()
    }
}
