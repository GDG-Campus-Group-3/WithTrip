package com.gdg.withtrip.network.response


import com.google.gson.annotations.SerializedName

data class GetDuplicatedUserResponse(
    @SerializedName("R")
    val r: R?
) {
    data class R(
        @SerializedName("CHECK")
        val check: Boolean?
    )
}