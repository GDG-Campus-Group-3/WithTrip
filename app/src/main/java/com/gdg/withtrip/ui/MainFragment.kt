package com.gdg.withtrip.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentMainBinding
import com.solar.universe.binding.UniverseViewFragment

class MainFragment : UniverseViewFragment<FragmentMainBinding>(R.layout.fragment_main, FragmentMainBinding::bind) {
    override fun onViewCreated(bind: FragmentMainBinding, savedInstanceState: Bundle?) {

        val navController = findNavController()
        bind.navView.setupWithNavController(navController)
    }

    companion object {
        fun moveNavDirection(fragment: Fragment?, action: NavDirections) {
            fragment?.let { frag ->
                if (frag is MainFragment) {
                    frag.findNavController().navigate(action)
                }
            }
        }
    }
}