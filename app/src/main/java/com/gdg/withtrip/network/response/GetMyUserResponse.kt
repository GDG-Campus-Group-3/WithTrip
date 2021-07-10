package com.gdg.withtrip.network.response


import com.google.gson.annotations.SerializedName

data class GetMyUserResponse(
    @SerializedName("R")
    val r: R?
) {
    data class R(
        @SerializedName("EX")
        val ex: String?,
        @SerializedName("NICKNAME")
        val nickname: String?
    )
}