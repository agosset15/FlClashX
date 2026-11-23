package net.usekago.app.service.models

data class NotificationParams(
    val title: String = "KAGO",
    val stopText: String = "STOP",
    val showStopAction: Boolean = true,
)
