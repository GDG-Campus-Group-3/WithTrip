package com.gdg.withtrip.network.mapper

import com.gdg.withtrip.network.response.GetBoardListResponse
import com.gdg.withtrip.network.response.GetDuplicatedUserResponse
import com.gdg.withtrip.network.response.GetMyUserResponse
import com.gdg.withtrip.ui.detail.ApplyState
import com.gdg.withtrip.ui.mypage.UserProfileModel
import com.gdg.withtrip.ui.popular.PopularCard
import javax.inject.Inject

class ResponseMapper @Inject constructor() {

    fun boardListToTripList(response: GetBoardListResponse): List<PopularCard> {
        return response.r?.list?.map {
            PopularCard(
                title = it?.title ?: "N/A",
                writer = it?.nickname ?: "N/A",
                image = "https://post-phinf.pstatic.net/MjAxODAzMDhfMTQ1/MDAxNTIwNDk1Mjk0MTY2.kmTCsEWbZonelokVlM8R8G1X4nw7ggUkalTFOIcUP1sg.4h7NpGXhL2ORXPeTGxPdCrh_FnOSSSTr8B5kCjU-244g.JPEG/seoul-travel-intro.jpg?type=w1200",
                place = it?.locationName ?: "N/A",
                people = "${it?.nowCount}/${it?.maxCount}",
                date = it?.startDate ?: "N/A",
                state = ApplyState.NOT_APPLY, //(it.state ?: 0)
                id = it?.seq!!,
                subtitle = "subtitle"
            )
        } ?: listOf()
    }

    fun mapToUserExist(response: GetDuplicatedUserResponse): Boolean {
        return response.r?.check ?: false
    }

    fun mapToUserInfo(response: GetMyUserResponse): UserProfileModel {
        return UserProfileModel(
            profileImage = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F993745425A80274C0E0C7A",
            name = response.r?.nickname ?: "N/A"
        )
    }
}