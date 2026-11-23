package net.usekago.app

import android.os.Bundle
import net.usekago.app.plugins.AppPlugin
import net.usekago.app.plugins.BatteryPlugin
import net.usekago.app.plugins.ServicePlugin
import net.usekago.app.plugins.TilePlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity : FlutterActivity() {
    private val highRefreshRate by lazy { HighRefreshRate(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Haptics.applyTo(this)
        if (savedInstanceState == null) {
            Haptics.rise(this, LAUNCH_RISE_MS)
        }
    }

    override fun onResume() {
        super.onResume()
        highRefreshRate.pin()
    }

    override fun onPause() {
        highRefreshRate.release()
        super.onPause()
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine.plugins.add(AppPlugin())
        flutterEngine.plugins.add(BatteryPlugin())
        flutterEngine.plugins.add(ServicePlugin())
        flutterEngine.plugins.add(TilePlugin())
        ServiceState.attachFlutterEngine(flutterEngine)
        flutterEngine.addEngineLifecycleListener(stopVibrationOnRestart)
    }

    // A hot restart drops the Dart side mid-hold without letting it stop the motor.
    private val stopVibrationOnRestart = object : FlutterEngine.EngineLifecycleListener {
        override fun onPreEngineRestart() = Haptics.stop(this@MainActivity)

        override fun onEngineWillDestroy() = Unit
    }

    override fun onDestroy() {
        flutterEngine?.removeEngineLifecycleListener(stopVibrationOnRestart)
        flutterEngine?.let(ServiceState::detachFlutterEngine)
        super.onDestroy()
    }
}

private const val LAUNCH_RISE_MS = 600L
