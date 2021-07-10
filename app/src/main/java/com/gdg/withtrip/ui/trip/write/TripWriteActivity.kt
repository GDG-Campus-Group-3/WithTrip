package com.gdg.withtrip.ui.trip.write

import android.os.Bundle
import androidx.activity.viewModels
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.datePicker
import com.gdg.withtrip.databinding.ActivityTripWriteBinding
import com.solar.universe.binding.UniverseViewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripWriteActivity : UniverseViewActivity<ActivityTripWriteBinding>(
    ActivityTripWriteBinding::inflate
) {

    private val tripWriteViewModel: TripWriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tripWriteViewModel.toastMsgLiveData.observe(this, {

        })
        binding.feedWriteRegisterBtn.setOnClickListener {
            tripWriteViewModel.writeTrip(binding)
        }

        binding.feedWriteDate.setOnClickListener {
            MaterialDialog(this).show {
                datePicker { dialog, date ->
                    // Use date (Calendar)
                    binding.feedWriteDate.setText("$date")
                }
            }
        }

    }
}