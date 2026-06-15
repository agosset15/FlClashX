
-keep class com.kago.vpnapp.models.**{ *; }

# AIDL interfaces and Parcelable models in :service and :core
-keep class com.kago.vpnapp.service.** { *; }
-keep class com.kago.vpnapp.core.** { *; }
-keep class com.kago.vpnapp.common.** { *; }