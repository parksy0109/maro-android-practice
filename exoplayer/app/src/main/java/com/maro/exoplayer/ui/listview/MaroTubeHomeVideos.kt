package com.maro.exoplayer.ui.listview

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.maro.exoplayer.data.HomeVideo
import com.maro.exoplayer.utils.DeviceSizeUtils

@Composable
fun MaroTubeHomeVideos(
    navHostController: NavHostController,
    homeVideos: List<HomeVideo>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        homeVideos.forEach {
            MaroTubeHomeVideo(homeVideo = it, setOnClickListener = { id ->
                navHostController.navigate("videos/$id")
            })
        }
    }
}

@Composable
fun MaroTubeHomeVideo(
    homeVideo: HomeVideo,
    setOnClickListener: (Long) -> Unit
) {

    val context = LocalContext.current

    val thumbnailHeight = DeviceSizeUtils.calculateHeight(context)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                setOnClickListener(homeVideo.id)
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(thumbnailHeight.dp),
            painter = homeVideo.thumbnail,
            contentDescription = null
        )
        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Card(
                shape = CircleShape,
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
            ) {
                Image(painter = homeVideo.userProfileImage, contentDescription = null)
            }
            Column {
                Text(
                    text = homeVideo.title,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = homeVideo.username,
                    color = Color(0xFF9F9F9F)
                )
            }
        }

    }


}