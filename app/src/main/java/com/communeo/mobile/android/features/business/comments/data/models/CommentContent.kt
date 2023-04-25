package com.communeo.mobile.android.features.business.comments.data.models

import com.communeo.mobile.android.core.util.generateRandomSentence
import com.communeo.mobile.android.features.business.users.data.models.PublicUser
import kotlin.random.Random
import kotlinx.serialization.Serializable

@Serializable
data class CommentContent(
    val numLikes: Int,
    val content: String,
    val owner: PublicUser,
) {
    companion object {
        fun random(
            numLikes: Int? = null,
            content: String? = null,
            owner: PublicUser? = null,
        ): CommentContent {
            return CommentContent(
                numLikes = numLikes ?: Random.nextInt(),
                content = content ?: generateRandomSentence(10),
                owner = owner ?: PublicUser.random(),
            )
        }
    }
}
