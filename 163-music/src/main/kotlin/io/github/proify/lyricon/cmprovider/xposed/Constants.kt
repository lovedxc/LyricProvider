package io.github.proify.lyricon.cmprovider.xposed

import android.content.Context
import java.io.File

object Constants {
    const val PROVIDER_PACKAGE_NAME: String = "io.github.proify.lyricon.cmprovider"

    // 支持官方和荣耀版
    val MUSIC_PACKAGE_NAMES: Set<String> = setOf(
        "com.netease.cloudmusic",
        "com.hihonor.cloudmusic"
    )

    // 兼容旧代码，保留旧常量（默认官方）
    const val MUSIC_PACKAGE_NAME: String = "com.netease.cloudmusic"

    const val ICON: String = "" // left empty to avoid large inline content; replace with original if needed
}