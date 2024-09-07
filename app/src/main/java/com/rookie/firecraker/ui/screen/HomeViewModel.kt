package com.rookie.firecraker.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rookie.firecraker.model.mock.VideoInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    var avatarUrl by mutableStateOf("http://192.168.1.6:9000/avatar/189577158023315456.png")
    var searchText by mutableStateOf("")

    private var _videoList = MutableStateFlow<List<VideoInfo>>(VideoInfo.mockData())
    val videoList = _videoList.asStateFlow()


}