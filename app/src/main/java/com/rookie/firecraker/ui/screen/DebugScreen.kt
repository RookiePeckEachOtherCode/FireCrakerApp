package com.rookie.firecraker.ui.screen

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaMetadata
import androidx.media3.common.util.UnstableApi
import com.ramcosta.composedestinations.annotation.Destination
import com.rookie.firecraker.ui.component.VideoPlayer
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@UnstableApi
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun DebugScreen(
) {
    val mediaItem = VideoPlayerMediaItem.NetworkMediaItem(
        url = "http://192.168.1.6:9000/video/test.mp4",
        mimeType = "video/mp4",
        mediaMetadata = MediaMetadata.Builder().setTitle("Test").build()
    )


    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Debug") })
        }
    ) { inPadding ->
        BoxWithConstraints(modifier = Modifier.padding(inPadding)) {
            val maxHeight = maxHeight

            Column {
                VideoPlayer(
                    mediaItem = mediaItem,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(maxHeight.div(3))
                )
            }
        }
    }
}
