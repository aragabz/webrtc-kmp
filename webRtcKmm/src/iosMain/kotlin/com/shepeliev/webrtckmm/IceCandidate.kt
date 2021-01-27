package com.shepeliev.webrtckmm

import cocoapods.GoogleWebRTC.RTCIceCandidate
actual class IceCandidate constructor(val native: RTCIceCandidate) {

    actual constructor(
        sdpMid: String,
        sdpMLineIndex: Int,
        sdp: String,
    ) : this(RTCIceCandidate(sdp, sdpMLineIndex, sdpMid))

    actual val sdpMid: String = native.sdpMid!!
    actual val sdpMLineIndex: Int = native.sdpMLineIndex
    actual val sdp: String = native.sdp
}
