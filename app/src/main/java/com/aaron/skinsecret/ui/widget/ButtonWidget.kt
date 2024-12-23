package com.aaron.skinsecret.ui.widget

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonRound(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        content = content
    )
}