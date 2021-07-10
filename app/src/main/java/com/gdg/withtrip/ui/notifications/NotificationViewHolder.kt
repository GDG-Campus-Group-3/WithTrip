package com.gdg.withtrip.ui.notifications

import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.databinding.NotificationItemBinding
import com.solar.universe.extension.loadUrl

class NotificationViewHolder(
    private val bind: NotificationItemBinding
) : RecyclerView.ViewHolder(bind.root) {

    fun bind(model: Notification) {
        bind.notificationThumbnail.loadUrl(model.thumbnail)
        bind.notificationTitle.text = model.title
        bind.notificationSubtitle.text = model.subtitle
    }

    private inline fun exactPosition(action: (Int) -> Unit) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            action(position)
        }
    }
}