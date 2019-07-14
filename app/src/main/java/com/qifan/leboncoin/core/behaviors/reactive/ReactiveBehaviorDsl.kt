package com.qifan.leboncoin.core.behaviors.reactive

/**
 * Created by Qifan on 2019-07-13.
 */
fun ReactiveBehavior.reactive(): ReactiveBehaviorObserver = ReactiveBehaviorObserver(this)
