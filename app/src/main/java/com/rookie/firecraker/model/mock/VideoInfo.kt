package com.rookie.firecraker.model.mock

data class VideoInfo(
    var title: String,
    var id: Long,
    var coverUrl: String,
    var authorName: String
) {
    companion object {
        fun mockData(): List<VideoInfo> {
            return listOf(
                VideoInfo("我的世界真人版", 1, "http://192.168.1.6:9000/cover/1.jpg", "user1"),
                VideoInfo("孩子入了邪教", 2, "http://192.168.1.6:9000/cover/2.jpg", "user2"),
                VideoInfo("LOL时停外挂", 3, "http://192.168.1.6:9000/cover/3.jpg", "user3"),
                VideoInfo(
                    "爷爷入局asdsdsdasdasdasdsadasdsdadawasdasdwadaw",
                    4,
                    "http://192.168.1.6:9000/cover/4.jpg",
                    "user4"
                ),
                VideoInfo("程序员如何摸鱼", 5, "http://192.168.1.6:9000/cover/5.jpg", "user5"),
                VideoInfo("你甚至不会花钱", 6, "http://192.168.1.6:9000/cover/6.jpg", "user6"),
                VideoInfo("端对端加密", 7, "http://192.168.1.6:9000/cover/7.jpg", "user7"),
                VideoInfo("纹身真相", 8, "http://192.168.1.6:9000/cover/8.jpg", "user8"),
            )
        }
    }
}


