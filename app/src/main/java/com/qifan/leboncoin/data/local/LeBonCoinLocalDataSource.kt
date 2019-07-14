package com.qifan.leboncoin.data.local

import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import com.qifan.leboncoin.domain.source.LeBonCoinDataStore
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */
class LeBonCoinLocalDataSource : LeBonCoinDataStore {
    override fun getData(): Flowable<List<LeBonCoinEntity>> {
        return Flowable.just(emptyList())
    }

}