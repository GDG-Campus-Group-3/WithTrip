package com.gdg.withtrip.ui.notifications

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.NotificationItemBinding
import com.gdg.withtrip.ui.base.AbstractAdapter

class NotificationAdapter  : AbstractAdapter<Notification>() {

    override fun getViewHolder(viewType: Int, view: View): RecyclerView.ViewHolder {
        return NotificationViewHolder(NotificationItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NotificationViewHolder) {
            holder.bind(array[position])
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.notification_item
}