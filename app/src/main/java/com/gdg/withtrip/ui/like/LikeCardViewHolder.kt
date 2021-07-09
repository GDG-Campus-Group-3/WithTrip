package com.gdg.withtrip.ui.like

import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.databinding.TripCard2Binding
import com.gdg.withtrip.ui.popular.PopularCard
import com.solar.universe.extension.loadUrl

class LikeCardViewHolder(
    private val bind: TripCard2Binding
) : RecyclerView.ViewHolder(bind.root) {

    fun bind(model: PopularCard) {
        bind.tripCard2Title.text = model.title
        bind.tripCard2Image.loadUrl(model.image)
    }

    private inline fun exactPosition(action: (Int) -> Unit) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            action(position)
        }
    }
}