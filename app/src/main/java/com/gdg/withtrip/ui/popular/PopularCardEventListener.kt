package com.gdg.withtrip.ui.popular

interface PopularCardEventListener {
    fun onClickCard(popularCard: PopularCard)
    fun onClickLike(popularCard: PopularCard)
}