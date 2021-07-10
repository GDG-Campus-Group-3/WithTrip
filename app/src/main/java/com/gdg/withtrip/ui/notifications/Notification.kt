package com.gdg.withtrip.ui.notifications

data class Notification(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val msg: String,
    val date : String
)