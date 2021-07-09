package com.gdg.withtrip.ui.popular

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.TripCard1Binding
import com.gdg.withtrip.ui.base.AbstractAdapter

class PopularCardAdapter(
    private val popularCardEventListener: PopularCardEventListener) : AbstractAdapter<PopularCard>() {

    override fun getViewHolder(viewType: Int, view: View): RecyclerView.ViewHolder {
        return PopularCardViewHolder(
            TripCard1Binding.bind(view),
            { onClickCardPosition ->
                popularCardEventListener.onClickCard(array[onClickCardPosition])
            },
            { onClickLikePosition ->
                popularCardEventListener.onClickLike(array[onClickLikePosition])
            }
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PopularCardViewHolder) {
            holder.bind(array[position])
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.trip_card_1
}