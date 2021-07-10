package com.gdg.withtrip.network.response


import com.google.gson.annotations.SerializedName

data class GetBoardListResponse(
    @SerializedName("R")
    val r: R?
) {
    data class R(
        @SerializedName("LIST")
        val list: List<LIST?>?
    ) {
        data class LIST(
            @SerializedName("LAST_DATE")
            val lASTDATE: String?,
            @SerializedName("LOCATION_NAME")
            val locationName: String?,
            @SerializedName("MAX_COUNT")
            val maxCount: Int?,
            @SerializedName("NICKNAME")
            val nickname: String?,
            @SerializedName("NOW_COUNT")
            val nowCount: Int?,
            @SerializedName("SEQ")
            val seq: Int?,
            @SerializedName("START_DATE")
            val startDate: String?,
            @SerializedName("STATE")
            val state: Int?,
            @SerializedName("TITLE")
            val title: String?
        )
    }
}