package com.maro.exoplayer.ui.screen.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.maro.exoplayer.ui.player.VideoPlayer

@Composable
fun VideoScreen(
    navHostController: NavHostController,
    id: Int?
) {
    VideoPlayer()
}