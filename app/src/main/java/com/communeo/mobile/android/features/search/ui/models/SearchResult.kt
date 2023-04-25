package com.communeo.mobile.android.features.search.ui.models

import com.communeo.mobile.android.features.business.events.data.models.Event
import com.communeo.mobile.android.features.business.users.data.models.PublicUser

/**
 * Not pretty, but compromise for lack
 * of Either<A, B, C....> in kotlin
 */
sealed interface SearchResult {
    data class EventResult(
        val events: Event
    ) : SearchResult

    data class UserResult(
        val users: PublicUser,
    ) : SearchResult
}
