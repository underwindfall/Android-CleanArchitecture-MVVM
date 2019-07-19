package com.qifan.leboncoin.data.local

import com.qifan.leboncoin.data.local.dao.LeBonCoinLocalDao
import com.qifan.leboncoin.data.mapper.list.LeBonCoinLocalEntityMapper
import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import com.qifan.leboncoin.domain.source.LeBonCoinDataStore
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */
class LeBonCoinLocalDataSource(
    private val dao: LeBonCoinLocalDao,
    private val mapper: LeBonCoinLocalEntityMapper
) : LeBonCoinDataStore {

    override fun getData(): Flowable<List<LeBonCoinEntity>> {
        return dao.getAll()
            .map {
                it.map { item -> mapper.mapFromLocal(item) }
            }
    }

    override fun saveData(data: List<LeBonCoinEntity>): Completable {
        return Completable.fromCallable {
            data.forEach {
                dao.insertData(mapper.mapToLocal(it))
            }
        }
    }

    override fun clearData(): Completable {
        return Completable.fromCallable { dao.deleteAll() }
    }

    override fun isCached(): Flowable<Boolean> {
        return dao.getAll()
            .map { it.isNotEmpty() }
            .map { it }
    }
}