package com.gdg.withtrip.ui.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TripDetail(
    val seq : Int,
    val image: String,
    val name: String,
    val location: String,
    val title: String,
    val desc: String,
    val date : String
) : Parcelable