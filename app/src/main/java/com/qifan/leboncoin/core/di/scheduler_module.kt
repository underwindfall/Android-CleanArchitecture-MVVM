package com.qifan.leboncoin.core.di

import com.qifan.leboncoin.core.thread.JobExecutor
import com.qifan.leboncoin.core.thread.UiThread
import com.qifan.leboncoin.domain.executor.PostExecutionThread
import com.qifan.leboncoin.domain.executor.ThreadExecutor
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Created by Qifan on 2019-07-14.
 */
val schedulerModule = module {
    single { JobExecutor() } bind ThreadExecutor::class
    single { UiThread() } bind PostExecutionThread::class
}