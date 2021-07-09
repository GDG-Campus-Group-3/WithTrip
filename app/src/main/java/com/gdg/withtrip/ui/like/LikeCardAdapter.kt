package com.gdg.withtrip.ui.like

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.TripCard2Binding
import com.gdg.withtrip.ui.base.AbstractAdapter
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardViewHolder

class LikeCardAdapter : AbstractAdapter<PopularCard>() {

    override fun getViewHolder(viewType: Int, view: View): RecyclerView.ViewHolder {
        return LikeCardViewHolder(TripCard2Binding.bind(view))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LikeCardViewHolder) {
            holder.bind(array[position])
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.trip_card_2
}