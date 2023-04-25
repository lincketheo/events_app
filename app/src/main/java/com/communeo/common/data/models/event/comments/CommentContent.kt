package com.communeo.common.data.models.event.comments

import com.communeo.common.util.generateRandomSentence
import com.communeo.common.data.models.user.PublicUser
import com.communeo.common.data.repository.impl.FakeUserRepository
import kotlin.random.Random

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
                owner = owner ?: FakeUserRepository.randomUser(),
            )
        }
    }
}
