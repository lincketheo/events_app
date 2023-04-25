package com.communeo.mobile.android.features.search.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.communeo.mobile.android.core.logging.CommuneoLoggerFactory
import com.communeo.mobile.android.features.search.ui.models.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {
    private val logger = CommuneoLoggerFactory.getLogger(this)

    private val _uiState = MutableStateFlow(SearchUiState.initial)
    val uiState = _uiState.asStateFlow()

    fun onQueryChange(newQuery: String) {
        _uiState.update {
            it.copy(currentQueryText = newQuery)
        }
    }

    fun onSearch(query: String) {
        _uiState.update {
            it.copy(isSearchBarActive = false)
        }
    }

    fun onActiveChange(active: Boolean) {
        _uiState.update {
            val newQueryText = if (active) "" else "Search"
            it.copy(isSearchBarActive = active, currentQueryText = newQueryText)
        }
    }

    fun onPeopleTagToggled() {
        _uiState.update {
            it.copy(peopleFilterSelected = !it.peopleFilterSelected)
        }
    }

    fun onEventTagToggled() {
        _uiState.update {
            it.copy(eventsFilterSelected = !it.eventsFilterSelected)
        }
    }
}
