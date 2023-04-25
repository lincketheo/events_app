package com.communeo.mobile.android.features.business.comments.data.repository.impl

import com.communeo.mobile.android.features.business.comments.data.models.Comment
import com.communeo.mobile.android.features.business.comments.data.repository.CommentRepository
import com.communeo.mobile.android.features.business.comments.data.source.network.RemoteCommentDataSource
import com.communeo.mobile.android.features.business.comments.data.source.network.models.toComment
import javax.inject.Inject

class OnlyNetworkCommentRepositoryImpl @Inject constructor(
    private val remoteCommentDataSource: RemoteCommentDataSource,
) : CommentRepository {
    override suspend fun getCommentsForEvent(
        eventId: ULong,
        page: UInt,
        pageSize: UInt,
    ): List<Comment> {
        return remoteCommentDataSource.getCommentsForEvent(
            eventId = eventId,
            page = page,
            pageSize = pageSize,
        ).map { it.toComment() }
    }
}
