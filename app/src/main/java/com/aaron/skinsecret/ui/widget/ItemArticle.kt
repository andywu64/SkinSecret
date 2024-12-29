package com.aaron.skinsecret.ui.widget

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun ItemArticle() {
    var expanded by remember { mutableStateOf(false) }
    Row (
        //horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Column (
            //verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(1f)
        ) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    imageVector = Icons.Sharp.AccountCircle,
                    contentDescription = "image",
                )
                Text(
                    "作者",
                    modifier = Modifier.weight(1f)
                )
            }
            Text(
                "標題",
                modifier = Modifier.weight(1f)
            )
            Text(
                "文章內容擷取",
                modifier = Modifier.weight(1f)
            )
            Row (
                modifier = Modifier.weight(1f),
            ){
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
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    "發文時間",
                    modifier = Modifier.weight(2f)
                )
            }
        }
        Column (
            horizontalAlignment = Alignment.End,
            //modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_more_vert_60),
                    contentDescription = "more",
                    modifier = Modifier
                        .clickable {
                            expanded = !expanded
                        }
                )
            }
            if (expanded) {
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = {  Text("Refresh") },
                        onClick = { /* Handle refresh! */ }
                    )
                    DropdownMenuItem(
                        text = { Text("Settings") },
                        onClick = { /* Handle settings! */ }
                    )
                    DropdownMenuItem(
                        text = { Text("Send Feedback") },
                        onClick = { /* Handle send feedback! */ }
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.baseline_image_60),
                contentDescription = "image",
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.LTGRAY.toLong(),
    heightDp = 150,
)
@Composable
fun ItemArticlePreview() {
    ItemArticle()
}