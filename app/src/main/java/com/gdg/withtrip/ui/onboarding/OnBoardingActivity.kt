package com.gdg.withtrip.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.withtrip.databinding.ActivityOnboardingBinding
import com.solar.firebase.auth.library.AbstractFirebaseAuthActivity
import com.solar.firebase.auth.library.FirebaseAuthModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}