package com.gdg.withtrip.ui.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TripDetail(
    val image: String,
    val name: String,
    val location: String,
    val title: String,
    val desc: String
) : Parcelable