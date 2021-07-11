package com.gdg.withtrip.ui.trip.write

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.activity.viewModels
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.datePicker
import com.afollestad.materialdialogs.input.input
import com.gdg.withtrip.databinding.ActivityTripWriteBinding
import com.gdg.withtrip.extension.toDate
import com.gdg.withtrip.ui.map.CenterMapActivity
import com.solar.universe.binding.UniverseViewActivity
import com.solar.universe.extension.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripWriteActivity : UniverseViewActivity<ActivityTripWriteBinding>(
    ActivityTripWriteBinding::inflate
) {

    private val tripWriteViewModel: TripWriteViewModel by viewModels()

    private var personSelected: Boolean = false
    private var dateSelected: Boolean = false
    private var locationSelected: Boolean = false

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tripWriteViewModel.toastMsgLiveData.observe(this, {
            toast(it)
        })

        binding.feedWriteRegisterBtn.setOnClickListener {
            if (personSelected && dateSelected && locationSelected) {
                tripWriteViewModel.writeTrip(
                    bind = binding,
                    title = binding.feedWriteTitle.text.toString(),
                    personCount = binding.feedWritePerson.text.toString().toInt(),
                    startDate= binding.feedWriteStartDate.text.toString(),
                    endDate= binding.feedWriteEndDate.text.toString(),
                    location = "$latitude, $longitude"
                )
            } else {
                toast("나머지 정보를 입력해 주세요")
            }
        }

        binding.feedWriteLocation.setOnClickListener {
            startActivityForResult(
                Intent(this, CenterMapActivity::class.java),
                CenterMapActivity.REQUEST_CODE_CENTER
            )
        }

        binding.feedWriteStartDate.setOnClickListener {
            MaterialDialog(this).show {
                datePicker { dialog, date ->
                    // Use date (Calendar)
                    binding.feedWriteStartDate.setText(date.toDate())
                    dateSelected = true
                }
            }
        }

        binding.feedWriteEndDate.setOnClickListener {
            MaterialDialog(this).show {
                datePicker { dialog, date ->
                    // Use date (Calendar)
                    binding.feedWriteEndDate.setText(date.toDate())
                    dateSelected = true
                }
            }
        }

        binding.feedWritePerson.setOnClickListener {
            val type = InputType.TYPE_CLASS_NUMBER
            MaterialDialog(this).show {
                input(inputType = type, waitForPositiveButton = false) { dialog, text ->
                    personSelected = true
                    binding.feedWritePerson.text = "$text" + "명"
                }
            }
        }
        binding.feedWriteBack.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CenterMapActivity.REQUEST_CODE_CENTER) {
            if (resultCode == RESULT_OK) {
                data?.let {
                    locationSelected = true
                    latitude = it.getDoubleExtra(CenterMapActivity.KEY_LATITUDE, 0.0)
                    longitude = it.getDoubleExtra(CenterMapActivity.KEY_LONGITUDE, 0.0)
                }
            }
        }
    }
}