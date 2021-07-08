package com.gdg.withtrip.ui.popular

import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.databinding.TripCard1Binding
import com.solar.universe.extension.loadUrl

class PopularCardViewHolder(
    private val bind: TripCard1Binding,
    private val onClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(bind.root) {

    init {
        bind.root.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onClick(position)
            }
        }
    }

    fun bind(model: PopularCard) {
        bind.tripCard1Title.text = model.title
        bind.tripCard1Subtitle.text = model.subtitle
        bind.tripCard1Image.loadUrl(model.image)
    }
}