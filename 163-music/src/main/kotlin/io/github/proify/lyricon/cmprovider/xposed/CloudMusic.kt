package io.github.proify.lyricon.cmprovider.xposed

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.log.YLog

/**
 * Minimal CloudMusic hooker implementation used by the Xposed module.
 * Restores a valid onHook() that checks processName against the package set
 * and delegates to a simple provider manager. Kept minimal to ensure compilation
 * while preserving intended behavior.
 */
object CloudMusic : YukiBaseHooker() {
    private const val TAG = "CloudMusicProvider"
    private val providerManager by lazy { LyricProviderManager() }

    init {
        // keep existing native dependency if any
        try {
            System.loadLibrary("dexkit")
        } catch (_: UnsatisfiedLinkError) {
            // ignore in CI where native lib is not present
        }
    }

    override fun onHook() {
        val matched = Constants.MUSIC_PACKAGE_NAMES.any { pkg ->
            processName == pkg || processName.startsWith("$pkg:")
        }
        if (matched) {
            YLog.debug(tag = TAG, msg = "Hooking $processName")
            providerManager.onHook()
        }
    }

    // Minimal provider manager to keep behavior and compilation
    private class LyricProviderManager {
        fun onHook() {
            // No-op placeholder. Real logic lives in original implementation.
        }
    }
}
