package com.aaron.skinsecret.ui.widget

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ChipColors
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.aaron.skinsecret.R

@Composable
fun SuggestionChipWidget(
    enabled: Boolean = true,
    borderEnabled: Boolean = false,
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    colors: ChipColors = ChipColors(
        labelColor = Gray,
        disabledLabelColor = Gray,
        containerColor = Transparent,
        disabledContainerColor = LightGray,
        leadingIconContentColor = Transparent,
        trailingIconContentColor = Transparent,
        disabledLeadingIconContentColor = Transparent,
        disabledTrailingIconContentColor = Transparent,
    )
) {
    Log.d("tag_suggestion_chip_widget", "show SuggestionChipWidget")
    SuggestionChip(
        enabled = enabled,
        onClick = onClick,
        colors = colors,
        border = suggestionChipBorder(borderEnabled),
        label =  label
    )
}

@Composable
fun suggestionChipBorder(enabled: Boolean) : BorderStroke? {
    if (enabled) {
        return SuggestionChipDefaults.suggestionChipBorder(true)
    }
    return null
}

@Preview(
    showBackground = true,
    backgroundColor = Color.WHITE.toLong()
)
@Composable
fun ChipWidgetPreview() {
    var index by remember { mutableIntStateOf(1) }
    Column {
        SuggestionChipWidget(
            enabled = index != 1,
            label = {
                Text(stringResource(R.string.day))
            },
            onClick = {
                index = 1
            }
        )
        SuggestionChipWidget(
            enabled = index != 2,
            label = {
                Text(stringResource(R.string.week))
            },
            onClick = {
                index = 2
            }
        )
    }
}
