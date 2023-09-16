package com.carry.slideconflict.bean

import kotlinx.serialization.Serializable

/**
 * Create by SunnyDay /09/16 12:11:09
 */
@Serializable
data class LyricData(
    val lyricList: List<Lyric>
)

@Serializable
data class Lyric(
    val lyricTitle: String,
    val lyrics: List<String>
)




