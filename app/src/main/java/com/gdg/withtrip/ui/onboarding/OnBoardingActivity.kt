package com.gdg.withtrip.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.withtrip.KEY_SEQ
import com.gdg.withtrip.MainActivity
import com.gdg.withtrip.databinding.ActivityOnboardingBinding
import com.gdg.withtrip.util.Prefs
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


        if (Prefs.getString(KEY_SEQ, "").isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}