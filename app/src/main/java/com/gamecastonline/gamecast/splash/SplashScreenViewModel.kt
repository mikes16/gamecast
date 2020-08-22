package com.gamecastonline.gamecast.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gamecastonline.gamecast.base.viewModel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class SplashScreenViewModel : BaseViewModel() {

    private val screenLoadingEnd: MutableLiveData<Boolean> = MutableLiveData()
    private val letterUpdate: MutableLiveData<String> = MutableLiveData()

    init {
        animateLetter(5)
    }

    fun screenLoadingEnd(): LiveData<Boolean> = screenLoadingEnd
    fun letterUpdate(): LiveData<String> = letterUpdate

    /**
     * Creates a LiveData to return the letter to update in the View and animate the letters
     *
     * @param time The interval time to make this a recursive function
     * */
    private fun animateLetter(time: Long) {
        val sleep = time + 5
        viewModelScope.launch {
            if(sleep > 120){
                screenLoadingEnd.postValue(true)
            } else {
                delay(sleep)
                letterUpdate.postValue(getRandomString())
                animateLetter(sleep)
            }
        }
    }

    /**
     * Get 1 random letter from A to Z
     */
    private fun getRandomString(): String {
        val range = ('a'..'z')
        val length = 1
        return (1..length)
            .map { (Random().nextInt(range.last.toInt() - range.first.toInt()) + range.first.toInt()).toChar() }
            .joinToString("")
    }

}