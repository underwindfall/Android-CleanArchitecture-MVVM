package com.qifan.leboncoin.domain

import com.qifan.leboncoin.domain.executor.PostExecutionThread
import com.qifan.leboncoin.domain.executor.ThreadExecutor
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */
abstract class UseCase<in Params, T> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

    protected abstract fun buildUseCaseObservable(params: Params? = null): Flowable<T>

    fun execute(params: Params? = null): Flowable<T> =
        buildUseCaseObservable(params)
            .subscribeOn(threadExecutor.scheduler)
            .observeOn(postExecutionThread.scheduler)

}