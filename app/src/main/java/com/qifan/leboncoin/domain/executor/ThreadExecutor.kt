package com.qifan.leboncoin.domain.executor

import io.reactivex.Scheduler

/**
 * Created by Qifan on 2019-07-14.
 */
interface ThreadExecutor {
    val scheduler: Scheduler
}