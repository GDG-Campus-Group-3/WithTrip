package com.gdg.withtrip.ui

import com.gdg.withtrip.ui.detail.ApplyState
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.map.MapMarker
import com.gdg.withtrip.ui.notifications.Notification
import com.gdg.withtrip.ui.popular.PopularCard

object MockData {
    fun randomCityName(): String {
        return mockCities.shuffled().first()
    }

    fun randomCityImage(): String {
        return mockCityImages.shuffled().first()
    }

    fun randomPopularMockData(): List<PopularCard> {
        return List(10) { getPopularCardMock() }.shuffled()
    }

    fun getPopularCardMock() = PopularCard(
        title = randomCityName(),
        writer = "3조",
        image = randomCityImage(),
        place = "서울",
        date = "2021.07.20 10:00:00",
        people = "2/4",
        state = ApplyState.values().toList().shuffled().first()
    )

    fun getNotificationList() = List(24) {
        getNotification(it)
    }

    fun getMapMarkerList() = listOf(
        MapMarker(
            thumbnail = randomCityImage(),
            title = randomCityName(),
            37.551692,
            126.922946
        ),
        MapMarker(
            thumbnail = randomCityImage(),
            title = randomCityName(),
            37.553692, 126.922314
        ),
        MapMarker(
            thumbnail = randomCityImage(),
            title = randomCityName(),
            37.553692, 126.922314
        ),
        MapMarker(
            thumbnail = randomCityImage(),
            title = randomCityName(),
            37.55532, 126.926892
        ),
        MapMarker(
            thumbnail = randomCityImage(),
            title = randomCityName(),
            37.555106, 126.915943
        )
    )

    fun getNotification(id: Int) = Notification(
        id = id,
        thumbnail = randomCityImage(),
        title = randomCityName(),
        subtitle = randomCityName()
    )

    val mockCities = listOf(
        "Amsterdam, Netherlands",
        "Barcelona, Spain",
        "Beijing, China",
        "Beirut, Lebanon",
        "Bergen, Norway",
        "Bruges, Belgium",
        "Budapest, Hungary",
        "Buenos Aires, Argentina",
        "Cape Town, South Africa",
        "Cartagena, Colombia",
        "Chefchaouen, Morocco",
        "Chiang Mai, Thailand",
        "Copenhagen, Denmark",
        "Cusco, Peru"
    )

    //https://www.cntraveler.com/galleries/2016-01-08/the-50-most-beautiful-cities-in-the-world

    val mockCityImages = listOf(
        "https://media.cntraveler.com/photos/5fc6818f3cfe1de2cab79372/master/w_1600%2Cc_limit/Amsterdam-GettyImages-840603854.jpg",
        "https://media.cntraveler.com/photos/5ca50f2719fc38d59c1a31b4/master/w_1600%2Cc_limit/Barcelona_GettyImages-720036297.jpg",
        "https://media.cntraveler.com/photos/5fd0dee324d6251eeb2e5ec7/master/w_1600%2Cc_limit/BestCitiesInTheWorld-2020-Beijing%2C%2520China-GettyImages-700672514.jpg",
        "https://media.cntraveler.com/photos/5ca50f277b531a543d949ccb/master/w_1600%2Cc_limit/Beirut_GettyImages-626502584.jpg",
        "https://media.cntraveler.com/photos/5fd0dee83cfe1de2cab7953a/master/w_1600%2Cc_limit/BestCitiesInTheWorld-2020-Bergen%2C%2520Norway-GettyImages-1169113458.jpg",
        "https://media.cntraveler.com/photos/588a0a4fbc3623e22c9e89de/master/w_1600%2Cc_limit/bruges-Gallery-Stock-GS01079498.jpg",
        "https://media.cntraveler.com/photos/5bd0cb986965116f2b13ad94/master/w_1600%2Cc_limit/Budapest_GettyImages-96169945.jpg",
        "https://media.cntraveler.com/photos/5fc66ede013df4de80687b39/master/w_1600%2Cc_limit/Buenos-Aires-GettyImages-1129443180.jpg",
        "https://media.cntraveler.com/photos/5ca50f287b531a2949949ccf/master/w_1600%2Cc_limit/Cape-Town-South-Africa_GettyImages-477451698.jpg",
        "https://media.cntraveler.com/photos/5ca50f287b531a0878949cd1/master/w_1600%2Cc_limit/Cartagena%2C-Colombia_GettyImages-675606245.jpg",
        "https://media.cntraveler.com/photos/5f3a8c50ccf45d10e984e7d2/master/w_1600%2Cc_limit/Chefchaouen-Morocco-GettyImages-531259682.jpg",
        "https://media.cntraveler.com/photos/5fd0ded7aa9fb907eb94c0f2/master/w_1600%2Cc_limit/BestCitiesInTheWorld-2020-Chiang%2520Mai%2C%2520Thailand-GettyImages-668710572.jpg",
        "https://media.cntraveler.com/photos/5ca4fa6c2741324d1b073bac/master/w_1600%2Cc_limit/Copenhagen_GettyImages-1044373262.jpg",
        "https://media.cntraveler.com/photos/5fd0dedd24d6251eeb2e5ec5/master/w_1600%2Cc_limit/BestCitiesInTheWorld-2020-Cusco%2C%2520Peru-GettyImages-515972508.jpg"
    )

    val mockTripDetailData: TripDetail
        get() = TripDetail(
            image = randomCityImage(),
            name = randomCityName(),
            location = randomCityName(),
            title = "About this trip \uD83D\uDE0D",
            desc = lorem,
            date = "2021.02.02"
        )

    val lorem = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."


}