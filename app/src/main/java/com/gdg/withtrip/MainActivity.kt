package com.gdg.withtrip

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gdg.withtrip.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

interface SearchToolBarController{
    val searchWord : LiveData<String>
    fun updateSearchWord(word : String)
}

interface SearchToolBarHolder{
    fun getController() : SearchToolBarController
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() ,SearchToolBarHolder{

    private lateinit var binding: ActivityMainBinding

    val viewModel: MainViewModel by viewModels()

    override fun getController(): SearchToolBarController  = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_fragment_main)
        navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.tripDetailFragment2,R.id.myFeedFragment ->hideToolbar()
                else -> showToolbar()
            }
        }
        initToolbar()
    }

    private fun initToolbar(){
        binding.etSearch.addTextChangedListener { text ->
            val searchWord = text.toString()
            viewModel.updateSearchWord(searchWord)
        }
    }

    private fun hideToolbar() {
        binding.tbSearch.isVisible = false
    }

    private fun showToolbar() {
        binding.tbSearch.isVisible = true
    }
}