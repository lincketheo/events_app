package com.communeo.mobile.android.features.business.comments.data.source.network

import com.communeo.mobile.android.features.business.comments.data.source.network.models.CommentResponse

interface RemoteCommentDataSource {
    suspend fun getCommentsForEvent(
        eventId: ULong,
        page: UInt,
        pageSize: UInt,
    ): List<CommentResponse>
}
