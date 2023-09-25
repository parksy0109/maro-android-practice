package com.maro.exoplayer.ui.screen.pages.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.maro.exoplayer.R
import com.maro.exoplayer.data.HomeVideo
import com.maro.exoplayer.ui.listview.MaroTubeHomeVideos

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    MaroTubeHomeVideos(
        navHostController,
        homeVideos = listOf(
            HomeVideo(
                id = 1,
                thumbnail = painterResource(id = R.drawable.home_video_thumbnail_sample_1),
                userProfileImage = painterResource(id = R.drawable.home_video_thumbnail_sample_1),
                username = "Maro Park",
                title = "Full Guide to Manual Dependency Injection + Removing Dagger"
            ),
            HomeVideo(
                id = 2,
                thumbnail = painterResource(id = R.drawable.home_video_thumbnail_sample_2),
                userProfileImage = painterResource(id = R.drawable.home_video_thumbnail_sample_2),
                username = "Park Maro",
                title = "Android Push Notification Using Firebase Cloud Messaging in Kotlin | GeeksforGeeks"
            )
        )
    )
}