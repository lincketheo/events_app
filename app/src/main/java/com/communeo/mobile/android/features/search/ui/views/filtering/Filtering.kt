package com.communeo.mobile.android.features.search.ui.views.filtering

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.communeo.mobile.android.R

@Composable
fun BooleanFilterTags(
    eventTagSelected: Boolean,
    peopleTagSelected: Boolean,
    onPeopleTagToggled: () -> Unit,
    onEventTagToggled: () -> Unit,
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CheckMarkSearchFilterChip(
            text = "People",
            currentlySelected = peopleTagSelected,
            toggle = onPeopleTagToggled,
        )
        CheckMarkSearchFilterChip(
            text = "Events",
            currentlySelected = eventTagSelected,
            toggle = onEventTagToggled,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckMarkSearchFilterChip(
    text: String,
    currentlySelected: Boolean,
    toggle: () -> Unit,
) {
    FilterChip(
        modifier = Modifier
            .padding(6.dp),
        selected = currentlySelected,
        onClick = toggle,
        leadingIcon = {
            AnimatedVisibility(
                visible = currentlySelected,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_check_24),
                    contentDescription = "check mark"
                )
            }
        },
        label = { Text(text) }
    )
}
