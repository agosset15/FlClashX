package net.usekago.app.service.modules

import android.app.Notification.FOREGROUND_SERVICE_IMMEDIATE
import android.app.Service
import android.app.Service.STOP_FOREGROUND_REMOVE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import net.usekago.app.common.Components
import net.usekago.app.common.GlobalState
import net.usekago.app.common.QuickAction
import net.usekago.app.common.ensureNotificationChannel
import net.usekago.app.common.quickIntent
import net.usekago.app.common.receiveBroadcastFlow
import net.usekago.app.common.startForeground
import net.usekago.app.common.toPendingIntent
import net.usekago.app.service.R
import net.usekago.app.service.ServiceConfig
import net.usekago.app.service.models.NotificationParams
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class NotificationModule(
    private val service: Service,
    private val scope: CoroutineScope,
) : ServiceModule {
    override fun start() {
        service.ensureNotificationChannel()
        update(ServiceConfig.notificationParams.value)
        scope.launch {
            // Some ROMs, vivo's among them, drop updates posted behind the
            // keyguard, so unlocking posts once more. SystemUI, an app, sends
            // USER_PRESENT, which a receiver that is not exported never gets;
            // the action is protected.
            val unlocked = service.receiveBroadcastFlow(exported = true) {
                addAction(Intent.ACTION_USER_PRESENT)
            }.map { }.onStart { emit(Unit) }
            combine(unlocked, ServiceConfig.notificationParams) { _, params -> params }
                .collect(::update)
        }
    }

    private val notificationBuilder: NotificationCompat.Builder by lazy {
        val intent = Intent().setComponent(Components.mainActivity)

        NotificationCompat.Builder(
            service,
            GlobalState.NOTIFICATION_CHANNEL,
        ).apply {
            setSmallIcon(R.drawable.ic_service)
            setContentTitle("KAGO")
            setContentIntent(intent.toPendingIntent)
            setPriority(NotificationCompat.PRIORITY_LOW)
            setCategory(NotificationCompat.CATEGORY_SERVICE)
            setOngoing(true)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                foregroundServiceBehavior = FOREGROUND_SERVICE_IMMEDIATE
            }
            setShowWhen(true)
            setOnlyAlertOnce(true)
        }
    }

    private val stopIntent by lazy { QuickAction.STOP.quickIntent.toPendingIntent }

    private fun update(params: NotificationParams) {
        service.startForeground(
            with(notificationBuilder) {
                setContentTitle(params.title)
                clearActions()
                if (params.showStopAction) {
                    addAction(0, params.stopText, stopIntent)
                }
                build()
            },
        )
    }

    @Suppress("DEPRECATION")
    override fun stop() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            service.stopForeground(STOP_FOREGROUND_REMOVE)
        } else {
            service.stopForeground(true)
        }
    }
}
