package com.qifan.leboncoin.domain.repository

import com.qifan.leboncoin.domain.Repository
import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import com.qifan.leboncoin.domain.source.LeBonCoinDataStoreFactory
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */
class GetLeBonCoinRepository(private val factory: LeBonCoinDataStoreFactory) : Repository<LeBonCoinEntity> {
    override fun clearData(): Completable {
        return factory.getLocalDataStore().clearData()
    }

    override fun saveData(data: List<LeBonCoinEntity>): Completable {
        return factory.getLocalDataStore().saveData(data)
    }

    override fun getData(): Flowable<List<LeBonCoinEntity>> {
        return factory.getLocalDataStore().isCached()
            .flatMapPublisher {
                factory.getDataStore(it).getData()
            }
            .flatMap {
                saveData(it).toSingle { it }.toFlowable()
            }
    }
}