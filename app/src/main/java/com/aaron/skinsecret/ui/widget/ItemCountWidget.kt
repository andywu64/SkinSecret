package com.aaron.skinsecret.ui.widget

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.skinsecret.R
import com.aaron.skinsecret.util.ImageState
import com.aaron.skinsecret.util.ItemCountState

@Composable
fun MultipleItemCount(
    items: List<ItemCountState>,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier.padding(2.dp)
    ) {
        items.forEach {
            ItemCount(
                data = it,
            )
        }
    }
}


@Composable
private fun ItemCount(
    data: ItemCountState,
    modifier: Modifier = Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier.padding(2.dp)
    ) {
        Icon(
            painter = data.imagePainter,
            contentDescription = data.imageContent,
            modifier = Modifier.size(24.dp)
        )
        Text(data.count)
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
    //heightDp = 40,
)
@Composable
fun MultipleItemCountPreview() {
    MultipleItemCount(
        items = listOf(
            ItemCountState(
                image = ImageState(
                    title = "Favorite",
                    painter = rememberVectorPainter(Icons.Outlined.Favorite)
                ),
                count = "15"
            ),
            ItemCountState(
                image = ImageState(
                    title = "Favorite",
                    painter = painterResource(R.drawable.baseline_message_60)
                ),
                count = "15"
            ),
            ItemCountState(
                image = ImageState(
                    title = "Favorite",
                    painter = painterResource(R.drawable.baseline_bookmark_60)
                ),
                count = "15"
            ),
        ),
    )
}

@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
   //heightDp = 40,
)
@Composable
fun ItemCountPreview() {
    ItemCount(
        data = ItemCountState(
            image = ImageState(
                title = "Favorite",
                painter = rememberVectorPainter(Icons.Outlined.Favorite)
            ),
            count = "15"
        ),
    )
}