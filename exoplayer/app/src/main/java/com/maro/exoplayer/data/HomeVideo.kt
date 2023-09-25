package com.maro.exoplayer.data

import androidx.compose.ui.graphics.painter.Painter

data class HomeVideo(
    val id: Long,
    val thumbnail: Painter,
    val userProfileImage: Painter,
    val username: String,
    val title: String,
)

