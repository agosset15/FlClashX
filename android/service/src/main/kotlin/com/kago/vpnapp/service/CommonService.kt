package com.kago.vpnapp.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.kago.vpnapp.common.GlobalState
import com.kago.vpnapp.common.SavedParams
import com.kago.vpnapp.common.promoteToForeground
import com.kago.vpnapp.service.models.VpnOptions
import kotlinx.coroutines.sync.withLock
import com.kago.vpnapp.service.modules.NetworkObserveModule
import com.kago.vpnapp.service.modules.NotificationModule

class CommonService : Service(), IBaseService {

    inner class LocalBinder : Binder() {
        val service: CommonService = this@CommonService
    }

    private val binder = LocalBinder()
    @Volatile override var destroyed = false

    private val loader = moduleLoader {
        install { NetworkObserveModule(it) }
        install(::NotificationModule)
    }

    override fun onCreate() {
        super.onCreate()
        startForegroundCompat()
        handleCreate()
    }

    private fun startForegroundCompat() {
        promoteToForeground(R.drawable.ic_notification, SavedParams.loadNotificationTitle())
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == "com.kago.vpnapp.service.STOP") {
            GlobalState.launch { State.runLock.withLock { handleStop() } }
            return START_NOT_STICKY
        }
        // Proxy-only mode never persists a cold-start flag, so a STICKY recreate
        // would only resurrect an empty foreground notification over a dead core.
        // Don't auto-restart; the app re-establishes the core explicitly.
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        runCatching { kotlinx.coroutines.runBlocking { kotlinx.coroutines.withTimeoutOrNull(3000L) { loader.stop() } } }
        handleDestroy()
        super.onDestroy()
    }

    override suspend fun handleStart(options: VpnOptions) {
        loader.start()
    }

    override suspend fun handleStop() {
        State.runTime = 0L
        loader.stop()
        handleDestroy()
        stopSelf()
    }
}
