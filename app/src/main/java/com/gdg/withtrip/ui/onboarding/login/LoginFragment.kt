package com.gdg.withtrip.ui.onboarding.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gdg.withtrip.MainActivity
import com.gdg.withtrip.databinding.FragLoginBinding
import com.gdg.withtrip.ui.onboarding.OnBoardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val onBoardViewModel: OnBoardViewModel by viewModels()

    private var _binding: FragLoginBinding? = null
    private val binding: FragLoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragLoginBinding.inflate(layoutInflater, container, false)

        onBoardViewModel.isUserExistLiveData.observe(viewLifecycleOwner, { isExist ->
            if (isExist) {
                requireActivity().startActivity(Intent(requireActivity(), MainActivity::class.java))
                requireActivity().finish()
            }
        })

        binding.btnLogin.setOnClickListener {
            onBoardViewModel.isUserExist(binding.etId.text.toString())
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