package com.gdg.withtrip.ui.notifications

import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.databinding.NotificationItemBinding
import com.solar.universe.extension.loadUrl

class NotificationViewHolder(
    private val bind: NotificationItemBinding
) : RecyclerView.ViewHolder(bind.root) {

    fun bind(model: Notification) {
        bind.tripCard1Image.loadUrl(model.thumbnail)
        bind.tripCard1Title.text = model.title
        bind.tvDate.text = model.date
        bind.tvMsg.text = model.msg
    }
}