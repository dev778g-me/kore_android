package com.dev.korelibrary.src.Components.Stack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.dev.korelibrary.src.Components.Themes.KoreTheme

@Composable
fun VerticalStack(
    modifier: Modifier = Modifier,
    spacing: Dp = KoreTheme.sizes.small,
    horizontalAlignment: Alignment.Horizontal = StackDefaults.defaultHorizontalAlignment,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spacing),
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}

@Composable
fun HorizontalStack(
    modifier: Modifier = Modifier,
    spacing: Dp = KoreTheme.sizes.small,
    verticalAlignment: Alignment.Vertical = StackDefaults.defaultVerticalAlignment,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = verticalAlignment,
        content = content
    )
}

object StackDefaults {
    val defaultHorizontalAlignment: Alignment.Horizontal =
        Alignment.CenterHorizontally

    val defaultVerticalAlignment: Alignment.Vertical =
        Alignment.CenterVertically
}