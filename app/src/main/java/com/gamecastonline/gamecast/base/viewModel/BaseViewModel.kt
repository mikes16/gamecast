package com.gamecastonline.gamecast.base.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gamecastonline.gamecast.network.exception.Failure
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.postValue(failure)
    }

    fun failure(): LiveData<Failure> = failure

}