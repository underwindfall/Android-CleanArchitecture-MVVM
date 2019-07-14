package com.qifan.leboncoin.core.behaviors

import androidx.lifecycle.Lifecycle

/**
 * Created by Qifan on 2019-07-13.
 */
interface BehaviorConsumer {
    val behaviors: BehaviorObservers

    fun Lifecycle.consumeBehaviors() {
        behaviors.forEach { behavior -> addObserver(behavior) }
    }

    fun Lifecycle.clearBehaviors() {
        behaviors.forEach { behavior -> removeObserver(behavior) }
    }
}