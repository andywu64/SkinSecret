package com.aaron.skinsecret.ui.widget

import android.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun <T> DropDownMenuWidget(
    expanded: Boolean = false,
    items: Map<String, T>,
    onDismissRequest: () -> Unit,
    onItemClick: (T) -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        items.forEach { (key, value) ->
            DropdownMenuItem(
                text = {
                    Text(key)
                       },
                onClick = {
                    onItemClick(value)
                }
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
    widthDp = 200,
    heightDp = 500,
)
@Composable
fun DropDownMenuWidgetPreview() {
    var show by remember { mutableStateOf(false) }
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ButtonRound(
            onClick = {
                show = true
            },
        ) { Text("測試 $show") }
        DropDownMenuWidget(
            expanded = show,
            items = mapOf(
                "Apple" to "Apple",
                Pair("Banana", "Apple"),
                Pair("Orange", "Apple")
            ),
            onDismissRequest = {
                show = false
            }
        ) {
            show = false
        }
    }
}