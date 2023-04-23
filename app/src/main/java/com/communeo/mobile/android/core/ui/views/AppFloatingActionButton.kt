package com.communeo.mobile.android.core.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import com.communeo.mobile.android.R

@Composable
fun AppFloatingActionButton(
    modifier: Modifier = Modifier,
    expanded: Boolean,
) {
    ExtendedFloatingActionButton(
        modifier = modifier
            .animateContentSize()
            .testTag("appFloatingActionButton"),
        onClick = { }
    ) {
        Icon(
            modifier = Modifier
                .testTag("appFloatingActionButtonIcon"),
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = "World"
        )
        if (expanded) {
            Text(
                modifier = Modifier.testTag("appFloatingActionButtonText"),
                text = "New"
            )
        }
    }
}
