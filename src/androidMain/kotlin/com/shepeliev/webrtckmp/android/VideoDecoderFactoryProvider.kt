package com.shepeliev.webrtckmp.android

import com.shepeliev.webrtckmp.WebRtcKmp
import com.shepeliev.webrtckmp.eglBase
import org.webrtc.DefaultVideoDecoderFactory
import org.webrtc.VideoDecoderFactory

fun interface VideoDecoderFactoryProvider {
    fun getVideoDecoderFactory(): VideoDecoderFactory

    companion object : VideoDecoderFactoryProvider {
        private var provider = VideoDecoderFactoryProvider {
            val eglBase = WebRtcKmp.eglBase
            DefaultVideoDecoderFactory(eglBase.eglBaseContext)
        }

        override fun getVideoDecoderFactory(): VideoDecoderFactory =
            provider.getVideoDecoderFactory()

        fun override(provider: VideoDecoderFactoryProvider) {
            this.provider = provider
        }
    }
}
