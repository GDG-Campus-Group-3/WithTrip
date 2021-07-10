package com.gdg.withtrip.ui.popular

import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.databinding.TripCard1V2Binding
import com.solar.universe.extension.loadUrl

class PopularCardViewHolder(
    private val bind: TripCard1V2Binding,
    private val popularCardEventListener : PopularCardEventListener
) : RecyclerView.ViewHolder(bind.root) {

    fun bind(model: PopularCard) {
        bind.root.setOnClickListener {
            popularCardEventListener.onClickCard(model)
        }
        bind.tripCard1Title.text = model.title
        bind.tvPlace.text = model.place
        bind.tvCalender.text = model.date
        bind.tvWriter.text = model.writer
        bind.tvPeople.text = model.people
        bind.tripCard1Image.loadUrl(model.image)
    }

    private inline fun exactPosition(action: (Int) -> Unit) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            action(position)
        }
    }
}
//
//class PopularCardViewHolder(
//    private val bind: TripCard1Binding,
//    private val onClickCard: (position: Int) -> Unit,
//    private val onClickFavorite: (position: Int) -> Unit
//) : RecyclerView.ViewHolder(bind.root) {
//
//    init {
//        bind.root.setOnClickListener {
//            exactPosition(onClickCard)
//        }
//        bind.tripCard1Like.setOnClickListener {
//            exactPosition(onClickFavorite)
//        }
//    }
//
//    fun bind(model: PopularCard) {
//        bind.tripCard1Title.text = model.title
//        bind.tripCard1Subtitle.text = model.subtitle
//        bind.tripCard1Image.loadUrl(model.image)
//    }
//
//    private inline fun exactPosition(action: (Int) -> Unit) {
//        val position = adapterPosition
//        if (position != RecyclerView.NO_POSITION) {
//            action(position)
//        }
//    }
//}