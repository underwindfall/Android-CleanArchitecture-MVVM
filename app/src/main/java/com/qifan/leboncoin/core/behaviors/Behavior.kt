package com.qifan.leboncoin.core.behaviors

import androidx.lifecycle.LifecycleObserver

/**
 * Created by Qifan on 2019-07-13.
 */
interface Behavior
typealias BehaviorObserver = LifecycleObserver
typealias BehaviorObservers = List<BehaviorObserver>