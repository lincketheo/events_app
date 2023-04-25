package com.communeo.mobile.android.features.business.comments.data.source.network.models

import com.communeo.mobile.android.features.business.comments.data.models.SubComment

typealias SubCommentResponse = SubComment

fun SubCommentResponse.toSubComment(): SubComment {
    return this
}
