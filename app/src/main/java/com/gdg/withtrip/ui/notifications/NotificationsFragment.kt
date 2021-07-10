package com.gdg.withtrip.ui.notifications

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentNotificationsBinding
import com.solar.universe.binding.UniverseViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : UniverseViewFragment<FragmentNotificationsBinding>(
    R.layout.fragment_notifications,
    FragmentNotificationsBinding::bind
) {

    private val notificationViewModel: NotificationsViewModel by viewModels()

    override fun onViewCreated(bind: FragmentNotificationsBinding, savedInstanceState: Bundle?) {
        notificationViewModel.notificationListLiveData.observe(viewLifecycleOwner, { notifications ->
            bind.notificationListView.adapter = NotificationAdapter().apply {
                submit(notifications)
            }
        })
    }
}