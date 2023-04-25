package com.communeo.mobile.android.features.business.users.data.models

import com.communeo.mobile.android.core.util.generateRandomUniqueName
import kotlin.random.Random
import kotlin.random.nextULong
import kotlinx.serialization.Serializable

@Serializable
data class PublicUser(
    val id: ULong,
    val name: String,
    val profilePictureUrl: String,
) {
    companion object {
        fun random(
            id: ULong? = null,
            name: String? = null,
            profilePictureUrl: String? = null,
        ): PublicUser {
            return PublicUser(
                id = id ?: Random.nextULong(),
                name = name ?: generateRandomUniqueName(),
                profilePictureUrl = profilePictureUrl ?: "https://picsum.photos/${
                Random.nextInt(
                    100,
                    300
                )
                }/${Random.nextInt(100, 300)}",
            )
        }
    }
}
