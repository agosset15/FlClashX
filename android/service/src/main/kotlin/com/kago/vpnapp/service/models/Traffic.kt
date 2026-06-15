package com.kago.vpnapp.service.models

import com.kago.vpnapp.common.formatBytes

data class Traffic(val up: Long = 0L, val down: Long = 0L) {
    val speedText: String get() = "${formatBytes(up)}/s ↑  ${formatBytes(down)}/s ↓"
}
