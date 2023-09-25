package com.maro.exoplayer.ui.footer

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.maro.exoplayer.R
import org.w3c.dom.Text


@Composable
fun BottomNavigationBar() {

    var selectedItem by remember { mutableIntStateOf(0) }

    val items = listOf(
        BottomBarMenu("홈", painterResource(id = R.drawable.baseline_home_24), painterResource(id = R.drawable.outline_home_24)),
        BottomBarMenu("인기", painterResource(id = R.drawable.baseline_local_fire_department_24), painterResource(id = R.drawable.outline_local_fire_department_24)),
        BottomBarMenu("보관함", painterResource(id = R.drawable.baseline_video_library_24), painterResource(id = R.drawable.outline_video_library_24)),
    )

    Column {
        Divider()
        NavigationBar(
            containerColor = Color.White
        ) {
            items.forEachIndexed { index, bottomBarMenu ->
                NavigationBarItem(
                    label = { Text(text = bottomBarMenu.title) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    icon = { if(selectedItem == index) Icon(painter = bottomBarMenu.clickedImage, contentDescription = null) else Icon(painter = bottomBarMenu.unClickedImage, contentDescription = null) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }
}