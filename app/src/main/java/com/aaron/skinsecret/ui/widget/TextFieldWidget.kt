package com.aaron.skinsecret.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaron.skinsecret.util.ImageState

@Composable
fun TextFieldInput(
    title: String? = null,
    label: @Composable (() -> Unit)? = null,
    input: String,
    onValueChange: (String) -> Unit,
    imageState: ImageState? = null,
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        title?.let{
            Text(
                text = it,
                fontSize = 16.sp
            )
        }
        OutlinedTextField(
            value = input,
            label = label,
            trailingIcon = {
                imageState?.let {
                    Image(
                        modifier = Modifier.size(60.dp),
                        imageVector = it.imageVector,
                        contentDescription = it.title,
                    )
                }
            },
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
