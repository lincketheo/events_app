package com.communeo.common.data.models.user

import com.communeo.common.util.generateRandomUniqueName

data class PublicUser(
    val name: String,
) {
    companion object {
        fun random(): PublicUser {
            return PublicUser(generateRandomUniqueName())
        }
    }
}

