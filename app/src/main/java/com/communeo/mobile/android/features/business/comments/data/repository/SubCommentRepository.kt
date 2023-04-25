package com.communeo.mobile.android.features.business.comments.data.repository

import com.communeo.mobile.android.features.business.comments.data.models.SubComment

interface SubCommentRepository {
    suspend fun getSubCommentsForComment(
        commentId: ULong,
        page: UInt,
        pageSize: UInt,
    ): List<SubComment>
}
