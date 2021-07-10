package com.gdg.withtrip.ui.mypage.apply

import android.graphics.Color
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.ApplyTripCardBinding
import com.gdg.withtrip.databinding.TripCard1V2Binding
import com.gdg.withtrip.ui.detail.ApplyState
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardEventListener
import com.solar.universe.extension.loadUrl

class ApplyTripCardViewHolder(
    private val bind: ApplyTripCardBinding,
    private val popularCardEventListener: PopularCardEventListener
) : RecyclerView.ViewHolder(bind.root) {

    fun bind(model: PopularCard) {
        bind.root.setOnClickListener {
            popularCardEventListener.onClickCard(model)
        }
        bind.tripCard1Title.text = model.title
        bind.tvPlace.text = model.place
        bind.tvCalender.text = model.date
        bind.tvApply.text = model.state.text
        when (model.state) {
            ApplyState.APPLY_CONFIRM -> {
                bind.tvApply.setTextColor(Color.parseColor("#2F80ED"))
            }
            ApplyState.APPLYING -> {
                bind.tvApply.setTextColor(Color.parseColor("#4F4F4F"))
            }
            ApplyState.NOT_APPLY -> {

            }
            ApplyState.CANCEL -> {
                bind.tvApply.setTextColor(Color.parseColor("#BDBDBD"))
                bind.tripCard1Title.setTextColor(Color.parseColor("#BDBDBD"))
                bind.tvPlace.setTextColor(Color.parseColor("#BDBDBD"))
                bind.tvCalender.setTextColor(Color.parseColor("#BDBDBD"))
                bind.tvPeople.setTextColor(Color.parseColor("#BDBDBD"))
                bind.tripCard1Image.alpha = 0.5f
            }
        }

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