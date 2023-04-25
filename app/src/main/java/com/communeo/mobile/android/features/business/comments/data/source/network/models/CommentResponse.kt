package com.communeo.mobile.android.features.business.comments.data.source.network.models

import com.communeo.mobile.android.features.business.comments.data.models.Comment

typealias CommentResponse = Comment

fun CommentResponse.toComment(): Comment {
    return this
}
