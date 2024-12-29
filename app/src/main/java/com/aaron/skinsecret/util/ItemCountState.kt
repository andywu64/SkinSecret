package com.aaron.skinsecret.util

import androidx.compose.ui.graphics.painter.Painter

data class ItemCountState(
    var image: ImageState,
    var count: String
) {
    val imagePainter: Painter = image.painter
    val imageContent: String = image.title
}