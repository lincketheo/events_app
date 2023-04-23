package com.communeo.mobile.android.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.communeo.mobile.android.features.search.ui.views.filtering.CheckMarkSearchFilterChip

data class ToggleableTag(
    val title: String,
    val isSelected: Boolean,
    val onClick: () -> Unit,
)

@Composable
fun RowOfToggleableTagsWithCheckMarks(
    toggleableTags: List<ToggleableTag>
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        toggleableTags.onEach {
            CheckMarkSearchFilterChip(
                text = it.title,
                currentlySelected = it.isSelected,
                toggle = it.onClick,
            )
        }
    }
}
