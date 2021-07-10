package com.gdg.withtrip

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gdg.withtrip.databinding.ActivityMainBinding
import com.gdg.withtrip.ui.trip.write.TripWriteActivity
import com.gdg.withtrip.ui.notifications.NotificationsFragmentDirections
import com.gdg.withtrip.ui.trip.write.TripWriteActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

interface SearchToolBarController {
    val searchWord: LiveData<String>
    fun updateSearchWord(word: String)
}

interface SearchToolBarHolder {
    fun getController(): SearchToolBarController
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchToolBarHolder {

    private lateinit var binding: ActivityMainBinding

    val viewModel: MainViewModel by viewModels()

    override fun getController(): SearchToolBarController = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_fragment_main)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.tripDetailFragment2, R.id.myFeedFragment, R.id.myApplyFeedFragment -> hideToolbar()
                else -> showToolbar()
            }
        }
        initToolbar()
        initFab()
    }

    private fun initFab() {
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(it.context, TripWriteActivity::class.java))
        }
    }

    private fun initToolbar() {
        binding.etSearch.addTextChangedListener { text ->
            val searchWord = text.toString()
            viewModel.updateSearchWord(searchWord)
        }
        binding.ivAlert.setOnClickListener {
            findNavController(R.id.nav_host_fragment_fragment_main).navigate(
                NotificationsFragmentDirections.actionGlobalNavigationNotifications()
            )
        }
    }

    private fun hideToolbar() {
        binding.tbSearch.isVisible = false
    }

    private fun showToolbar() {
        binding.tbSearch.isVisible = true
    }
}