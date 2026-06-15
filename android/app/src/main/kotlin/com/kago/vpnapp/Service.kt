package com.kago.vpnapp

import com.kago.vpnapp.common.ServiceDelegate
import com.kago.vpnapp.common.formatString
import com.kago.vpnapp.common.intent
import com.kago.vpnapp.service.IAckInterface
import com.kago.vpnapp.service.ICallbackInterface
import com.kago.vpnapp.service.IEventInterface
import com.kago.vpnapp.service.IRemoteInterface
import com.kago.vpnapp.service.IResultInterface
import com.kago.vpnapp.service.IVoidInterface
import com.kago.vpnapp.service.RemoteService
import com.kago.vpnapp.service.models.NotificationParams
import com.kago.vpnapp.service.models.VpnOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

object Service {
    private val delegate by lazy {
        ServiceDelegate<IRemoteInterface>(
            RemoteService::class.intent,
            onDisconnected = { handleServiceDisconnected(it) },
        ) { binder ->
            IRemoteInterface.Stub.asInterface(binder)
        }
    }

    var onServiceDisconnected: ((String) -> Unit)? = null

    private fun handleServiceDisconnected(message: String) {
        onServiceDisconnected?.invoke(message)
    }

    fun bind() {
        delegate.bind()
    }

    fun unbind() {
        delegate.unbind()
    }

    suspend fun invokeAction(data: String, cb: ((String) -> Unit)?): Result<Unit> {
        val chunks = Collections.synchronizedList(mutableListOf<ByteArray>())
        return delegate.useService { proxy ->
            proxy.invokeAction(data, object : ICallbackInterface.Stub() {
                override fun onResult(result: ByteArray?, isSuccess: Boolean, ack: IAckInterface?) {
                    chunks.add(result ?: byteArrayOf())
                    ack?.onAck()
                    if (isSuccess) cb?.invoke(chunks.formatString())
                }
            })
        }
    }

    suspend fun quickStart(
        initParamsString: String,
        paramsString: String,
        stateParamsString: String,
        onStarted: (() -> Unit)?,
        onResult: ((String) -> Unit)?,
    ): Result<Unit> {
        val chunks = Collections.synchronizedList(mutableListOf<ByteArray>())
        return delegate.useService { proxy ->
            proxy.quickStart(
                initParamsString,
                paramsString,
                stateParamsString,
                object : ICallbackInterface.Stub() {
                    override fun onResult(result: ByteArray?, isSuccess: Boolean, ack: IAckInterface?) {
                        chunks.add(result ?: byteArrayOf())
                        ack?.onAck()
                        if (isSuccess) onResult?.invoke(chunks.formatString())
                    }
                },
                object : IVoidInterface.Stub() {
                    override fun invoke() {
                        onStarted?.invoke()
                    }
                },
            )
        }
    }

    suspend fun setEventListener(cb: ((String?) -> Unit)?): Result<Unit> {
        val buffers = ConcurrentHashMap<String, MutableList<ByteArray>>()
        // Allow a slow cold-start bind (matches Dart's 15s init timeout) so the event
        // stream still registers instead of silently giving up after the 5s default.
        return delegate.useService(timeoutMillis = 15_000L) { proxy ->
            proxy.setEventListener(
                if (cb == null) null else object : IEventInterface.Stub() {
                    override fun onEvent(
                        id: String,
                        data: ByteArray?,
                        isSuccess: Boolean,
                        ack: IAckInterface?,
                    ) {
                        val list = buffers.getOrPut(id) { Collections.synchronizedList(mutableListOf()) }
                        list.add(data ?: byteArrayOf())
                        ack?.onAck()
                        if (isSuccess) {
                            cb(list.formatString())
                            buffers.remove(id)
                        }
                    }
                },
            )
        }
    }

    suspend fun updateNotificationParams(params: NotificationParams): Result<Unit> =
        delegate.useService { it.updateNotificationParams(params) }

    private suspend fun awaitResult(block: (IResultInterface) -> Unit): Long =
        suspendCancellableCoroutine { cont ->
            val cb = object : IResultInterface.Stub() {
                override fun onResult(runTime: Long) {
                    if (cont.isActive) cont.resume(runTime)
                }
            }
            runCatching { block(cb) }.onFailure {
                if (cont.isActive) cont.resumeWithException(it)
            }
        }

    suspend fun startService(options: VpnOptions, runTime: Long): Long =
        delegate.useService(timeoutMillis = 30_000L) { proxy ->
            awaitResult { cb -> proxy.startService(options, runTime, cb) }
        }.getOrNull() ?: 0L

    suspend fun stopService(): Long =
        delegate.useService(timeoutMillis = 15_000L) { proxy ->
            awaitResult { cb -> proxy.stopService(cb) }
        }.getOrNull() ?: 0L

    suspend fun setState(state: String): Result<Unit> =
        delegate.useService { it.setState(state) }

    suspend fun updateDns(dns: String): Result<Unit> =
        delegate.useService { it.updateDns(dns) }

    suspend fun getAndroidVpnOptions(): String =
        delegate.useService { it.androidVpnOptions }.getOrNull() ?: ""

    suspend fun getCurrentProfileName(): String =
        delegate.useService { it.currentProfileName }.getOrNull() ?: ""

    /** Returns null when the AIDL probe fails/times out (vs "" / a value on success). */
    suspend fun getRunTimeString(): String? =
        delegate.useService { it.runTime }.getOrNull()

    suspend fun getTraffic(): String =
        delegate.useService { it.traffic }.getOrNull() ?: ""

    suspend fun getTotalTraffic(): String =
        delegate.useService { it.totalTraffic }.getOrNull() ?: ""

    suspend fun startListener(): Result<Unit> =
        delegate.useService { it.startListener() }

    suspend fun stopListener(): Result<Unit> =
        delegate.useService { it.stopListener() }
}
