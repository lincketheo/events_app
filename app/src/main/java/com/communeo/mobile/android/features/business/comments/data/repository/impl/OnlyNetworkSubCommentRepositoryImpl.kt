package com.communeo.mobile.android.features.business.comments.data.repository.impl

import com.communeo.mobile.android.features.business.comments.data.models.SubComment
import com.communeo.mobile.android.features.business.comments.data.repository.SubCommentRepository
import com.communeo.mobile.android.features.business.comments.data.source.network.RemoteSubCommentDataSource
import com.communeo.mobile.android.features.business.comments.data.source.network.models.toSubComment

class OnlyNetworkSubCommentRepositoryImpl(
    private val remoteSubCommentDataSource: RemoteSubCommentDataSource,
) : SubCommentRepository {
    override suspend fun getSubCommentsForComment(
        commentId: ULong,
        page: UInt,
        pageSize: UInt
    ): List<SubComment> {
        return remoteSubCommentDataSource
            .getSubCommentsForComment(
                commentId = commentId,
                page = page,
                pageSize = pageSize,
            )
            .map { it.toSubComment() }
    }
}
