package com.aaron.skinsecret.ui.widget

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun ButtonRound(
    onClick: () -> Unit,
    shape: Shape = ButtonDefaults.outlinedShape,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = shape,
        modifier = modifier,
        content = content
    )
}