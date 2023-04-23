package com.communeo.mobile.android.features.search.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.communeo.mobile.android.features.search.ui.models.SearchResult

@Composable
fun SearchResultsEntryPoint(
    searchResults: List<SearchResult>,
) {
    LazyColumn {
        items(searchResults.size) {
            Text("Hola Amigo")
        }
    }
}
