package com.aaron.skinsecret.ui.widget

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaron.skinsecret.R
import com.aaron.skinsecret.util.ImageState

@Composable
fun TextFieldInput(
    title: String? = null,
    label: @Composable (() -> Unit)? = null,
    input: String,
    onValueChange: (String) -> Unit,
    imageState: ImageState? = null,
    modifier: Modifier = Modifier.padding(10.dp),
    fieldModifier: Modifier = Modifier,
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
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
            leadingIcon = imageState?.let {
                {
                    Image(
                        modifier = Modifier.size(60.dp),
                        painter = it.painter,
                        contentDescription = it.title,
                    )
                }
            },
            shape = RoundedCornerShape(12.dp),
            onValueChange = onValueChange,
            /*colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Red,
                unfocusedContainerColor = Yellow,
                focusedBorderColor = Blue,
                unfocusedBorderColor = Green,
            ),*/
            modifier = fieldModifier.fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong()
)
@Composable
fun TextFieldInputPreview() {
    var input by remember { mutableStateOf("") }
    TextFieldInput(
        input = input,
        label = {
            Text(stringResource(R.string.enter_keyword))
        },
        imageState = ImageState(
            title = stringResource(R.string.enter_keyword),
            painter = rememberVectorPainter(Icons.Filled.Search)
        ),
        onValueChange = {

        }
    )
}
