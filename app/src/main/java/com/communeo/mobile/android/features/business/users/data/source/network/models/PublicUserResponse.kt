package com.communeo.mobile.android.features.business.users.data.source.network.models

import com.communeo.mobile.android.features.business.users.data.models.PublicUser

typealias PublicUserResponse = PublicUser

fun PublicUserResponse.toPublicUser(): PublicUser {
    return this
}
