package com.gdg.withtrip.ui.onboarding.splash

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gdg.withtrip.MainActivity
import com.gdg.withtrip.databinding.FragSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragSplashBinding? = null
    private val binding: FragSplashBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragSplashBinding.inflate(layoutInflater, container, false)

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            )
        }
        binding.tvLook.setOnClickListener {
            requireActivity().startActivity(Intent(requireActivity(),MainActivity::class.java))
            requireActivity().finish()
        }


        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}