package com.gdg.withtrip.ui.onboarding.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdg.withtrip.MainActivity
import com.gdg.withtrip.databinding.FragLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragLoginBinding? = null
    private val binding: FragLoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragLoginBinding.inflate(layoutInflater, container, false)

        binding.btnLogin.setOnClickListener {
            requireActivity().startActivity(Intent(requireActivity(), MainActivity::class.java))
            requireActivity().finish()
        }
        binding.tvSignIn.setOnClickListener {
            requireActivity().startActivity(Intent(requireActivity(), MainActivity::class.java))
            requireActivity().finish()
        }


        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}