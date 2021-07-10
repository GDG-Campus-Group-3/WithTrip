package com.gdg.withtrip.ui.detail.v1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TripDetailV1(
    val image: String,
    val name: String,
    val location: String,
    val title: String,
    val desc: String
) : Parcelable