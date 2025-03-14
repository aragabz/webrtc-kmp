@file:OptIn(ExperimentalForeignApi::class)

package com.shepeliev.webrtckmp

import WebRTC.RTCAudioTrack
import kotlinx.cinterop.ExperimentalForeignApi

internal class LocalAudioStreamTrack(
    ios: RTCAudioTrack,
    override val constraints: MediaTrackConstraints,
) : MediaStreamTrackImpl(ios), AudioStreamTrack {
    override fun setVolume(volume: Double) {
        (ios as RTCAudioTrack).source.setVolume(volume)
    }
}
