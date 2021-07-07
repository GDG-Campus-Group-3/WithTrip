package com.gdg.withtrip.ui.popular

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.TripCard1Binding
import com.gdg.withtrip.ui.base.AbstractAdapter

class PopularCardAdapter : AbstractAdapter<PopularCard>() {

    override fun getViewHolder(viewType: Int, view: View): RecyclerView.ViewHolder {
        return PopularCardViewHolder(
            TripCard1Binding.bind(view)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PopularCardViewHolder) {
            println("Position: $position")
            holder.bind(array[position])
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.trip_card_1
}