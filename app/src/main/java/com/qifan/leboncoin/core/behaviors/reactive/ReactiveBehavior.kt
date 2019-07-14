package com.qifan.leboncoin.core.behaviors.reactive

import com.qifan.leboncoin.core.behaviors.Behavior
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Qifan on 2019-07-13.
 */
interface ReactiveBehavior : Behavior {
    fun startObserve(compositeDisposable: CompositeDisposable)
    fun stopObserve() {}
}