package com.gdg.withtrip.ui.mypage.apply

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.ApplyTripCardBinding
import com.gdg.withtrip.databinding.TripCard1Binding
import com.gdg.withtrip.databinding.TripCard1V2Binding
import com.gdg.withtrip.ui.base.AbstractAdapter
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardEventListener
import com.gdg.withtrip.ui.popular.PopularCardViewHolder

class ApplyTripCardAdapter(
    private val popularCardEventListener: PopularCardEventListener
) : ListAdapter<PopularCard, ApplyTripCardViewHolder>(PopularCardDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplyTripCardViewHolder {
        return ApplyTripCardViewHolder(
            ApplyTripCardBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            popularCardEventListener
        )
    }

    override fun onBindViewHolder(holder: ApplyTripCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


internal object PopularCardDiff : DiffUtil.ItemCallback<PopularCard>() {
    override fun areContentsTheSame(
        oldItem: PopularCard,
        newItem: PopularCard
    ): Boolean {
        return oldItem.title == newItem.title && oldItem.people == newItem.people && oldItem.date == newItem.date
    }

    override fun areItemsTheSame(
        oldItem: PopularCard,
        newItem: PopularCard
    ): Boolean {
        return oldItem.id == newItem.id
    }
}

//
//class PopularCardAdapter(
//    private val popularCardEventListener: PopularCardEventListener) : AbstractAdapter<PopularCard>() {
//
//    override fun getViewHolder(viewType: Int, view: View): RecyclerView.ViewHolder {
//        return PopularCardViewHolder(
//            TripCard1Binding.bind(view),
//            { onClickCardPosition ->
//                popularCardEventListener.onClickCard(array[onClickCardPosition])
//            },
//            { onClickLikePosition ->
//                popularCardEventListener.onClickLike(array[onClickLikePosition])
//            }
//        )
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is PopularCardViewHolder) {
//            holder.bind(array[position])
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int = R.layout.trip_card_1
//}