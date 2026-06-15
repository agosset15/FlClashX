package com.kago.vpnapp.service.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NotificationParams(
    val title: String = "KaGo",
    val stopText: String = "Stop",
) : Parcelable
