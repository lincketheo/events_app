package com.communeo.mobile.android.features.search.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SearchActiveEntryPoint(
    suggestions: List<String>,
) {
    LazyColumn {
        items(suggestions.size) {
            Text(suggestions[it])
        }
    }
}
