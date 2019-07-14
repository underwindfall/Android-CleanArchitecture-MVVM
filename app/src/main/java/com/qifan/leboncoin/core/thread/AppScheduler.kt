package com.qifan.leboncoin.core.thread

import com.qifan.leboncoin.domain.executor.PostExecutionThread
import com.qifan.leboncoin.domain.executor.ThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Qifan on 2019-07-14.
 */
class UiThread : PostExecutionThread {
    override val scheduler: Scheduler = AndroidSchedulers.mainThread()
}

class JobExecutor : ThreadExecutor {
    override val scheduler: Scheduler = Schedulers.io()
}