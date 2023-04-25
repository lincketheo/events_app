package com.communeo.mobile.android.features.search.ui.models

import com.communeo.mobile.android.features.business.events.data.models.EventFilter

/**
 * TODO - split this into several classes to minimize copies of large lists
 */
data class SearchUiState(
    val isSearchBarActive: Boolean,
    val currentQueryText: String,
    val peopleFilterSelected: Boolean,
    val eventsFilterSelected: Boolean,
    val eventsFilter: EventFilter?, // have memory of filter when toggling
    val searchResults: List<SearchResult>, // order matters
    val searchSuggestions: List<String>,
    val isLoading: Boolean,
) {
    companion object {
        val initial = SearchUiState(
            isSearchBarActive = false,
            currentQueryText = "Search",
            peopleFilterSelected = false,
            eventsFilterSelected = false,
            eventsFilter = null,
            searchResults = emptyList(),
            searchSuggestions = emptyList(),
            isLoading = false,
        )
    }
}
