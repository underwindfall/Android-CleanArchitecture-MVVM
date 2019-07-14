package com.qifan.leboncoin.domain.interactor

import com.qifan.leboncoin.domain.UseCase
import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import com.qifan.leboncoin.domain.executor.PostExecutionThread
import com.qifan.leboncoin.domain.executor.ThreadExecutor
import com.qifan.leboncoin.domain.repository.GetLeBonCoinRepository
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */
class GetLeBonCoinDataUseCase(
    private val repository: GetLeBonCoinRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<Void, List<LeBonCoinEntity>>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Flowable<List<LeBonCoinEntity>> {
        return repository.getData()
    }
}