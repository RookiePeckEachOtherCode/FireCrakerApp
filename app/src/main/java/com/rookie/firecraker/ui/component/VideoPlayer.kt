package com.rookie.firecraker.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

@Composable
fun VideoPlayer(
    mediaItem: VideoPlayerMediaItem,
    modifier: Modifier = Modifier
) {
    io.sanghun.compose.video.VideoPlayer(
        mediaItems = listOf(mediaItem),
        handleLifecycle = true,
        handleAudioFocus = true,
        autoPlay = true,
        usePlayerController = true,
        enablePip = true,
        controllerConfig = VideoPlayerControllerConfig.Default.copy(
            showSpeedAndPitchOverlay = true,
            showCurrentTimeAndTotalTime = true,
            showBufferingProgress = true,
            showForwardIncrementButton = false,
            showBackwardIncrementButton = false,
            showNextTrackButton = false,
            showBackTrackButton = false,
            showRepeatModeButton = true

        ),
        modifier = modifier
    )
}