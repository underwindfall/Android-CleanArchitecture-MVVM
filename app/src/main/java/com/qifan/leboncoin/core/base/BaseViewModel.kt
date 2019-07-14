package com.qifan.leboncoin.core.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Qifan on 2019-07-13.
 */
abstract class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    fun addDisposable(vararg disposable: Disposable) {
        disposables.addAll(*disposable)
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}