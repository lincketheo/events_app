package com.communeo.mobile.android.features.search.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.communeo.mobile.android.features.search.ui.models.SearchUiState
import com.communeo.mobile.android.features.search.ui.viewmodels.SearchViewModel
import com.communeo.mobile.android.features.search.ui.views.filtering.BooleanFilterTags

@Composable
fun SearchEntryPoint(
    searchViewModel: SearchViewModel,
) {
    val uiState by searchViewModel.uiState.collectAsState()
    StatelessSearch(
        uiState = uiState,
        onQueryChange = searchViewModel::onQueryChange,
        onSearch = searchViewModel::onSearch,
        onActiveChange = searchViewModel::onActiveChange,
        onPeopleTagToggled = searchViewModel::onPeopleTagToggled,
        onEventTagToggled = searchViewModel::onEventTagToggled,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatelessSearch(
    uiState: SearchUiState,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onActiveChange: (Boolean) -> Unit,
    onPeopleTagToggled: () -> Unit,
    onEventTagToggled: () -> Unit,
) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBar(
            query = uiState.currentQueryText,
            onQueryChange = { onQueryChange(it) },
            onSearch = { onSearch(it) },
            active = uiState.isSearchBarActive,
            onActiveChange = { onActiveChange(it) },
        ) {
            SearchActiveEntryPoint(suggestions = uiState.searchSuggestions)
        }
        BooleanFilterTags(
            eventTagSelected = uiState.eventsFilterSelected,
            peopleTagSelected = uiState.peopleFilterSelected,
            onPeopleTagToggled = onPeopleTagToggled,
            onEventTagToggled = onEventTagToggled,
        )
        SearchResultsEntryPoint(
            searchResults = uiState.searchResults,
        )
    }
}
