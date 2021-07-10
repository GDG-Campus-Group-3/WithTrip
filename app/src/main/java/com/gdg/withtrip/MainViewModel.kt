package com.gdg.withtrip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(), SearchToolBarController {

    private val _searchWord: MutableLiveData<String> = MutableLiveData()
    override val searchWord: LiveData<String> = _searchWord

    override fun updateSearchWord(word: String) {
        _searchWord.value = word
    }
}