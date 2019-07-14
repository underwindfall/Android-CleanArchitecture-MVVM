package com.qifan.leboncoin.domain.source

import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */
interface LeBonCoinDataStore {
    fun clearData(): Completable = Completable.complete()

    fun saveData(data: List<LeBonCoinEntity>): Completable = Completable.complete()

    fun getData(): Flowable<List<LeBonCoinEntity>>
}