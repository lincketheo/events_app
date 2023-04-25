package com.communeo.mobile.android.features.business.comments.data.repository

import com.communeo.mobile.android.features.business.comments.data.models.Comment

interface CommentRepository {
    suspend fun getCommentsForEvent(
        eventId: ULong,
        page: UInt,
        pageSize: UInt,
    ): List<Comment>
}
