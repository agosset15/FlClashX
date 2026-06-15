package com.kago.vpnapp.service

import com.kago.vpnapp.common.BroadcastAction
import com.kago.vpnapp.common.GlobalState
import com.kago.vpnapp.common.sendInternalBroadcast
import com.kago.vpnapp.service.models.VpnOptions

interface IBaseService {
    suspend fun handleStart(options: VpnOptions)
    suspend fun handleStop()

    var destroyed: Boolean

    fun handleCreate() {
        destroyed = false
        GlobalState.application.sendInternalBroadcast(BroadcastAction.SERVICE_CREATED.action)
    }

    fun handleDestroy() {
        if (destroyed) return
        destroyed = true
        GlobalState.application.sendInternalBroadcast(BroadcastAction.SERVICE_DESTROYED.action)
    }
}
