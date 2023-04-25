package com.communeo.mobile.android.features.business.comments.data.source.network

import com.communeo.mobile.android.features.business.comments.data.source.network.models.SubCommentResponse

interface RemoteSubCommentDataSource {
    suspend fun getSubCommentsForComment(
        commentId: ULong,
        page: UInt,
        pageSize: UInt,
    ): List<SubCommentResponse>
}
