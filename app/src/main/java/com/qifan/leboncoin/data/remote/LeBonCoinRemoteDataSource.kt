package com.qifan.leboncoin.data.remote

import com.qifan.leboncoin.data.mapper.list.LeBonCoinRemoteEntityMapper
import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import com.qifan.leboncoin.domain.source.LeBonCoinDataStore
import io.reactivex.Flowable


/**
 * Created by Qifan on 2019-07-13.
 */
class LeBonCoinRemoteDataSource(
    private val service: LeBonCoinService,
    private val mapper: LeBonCoinRemoteEntityMapper
) : LeBonCoinDataStore {

    override fun getData(): Flowable<List<LeBonCoinEntity>> {
        return service.getData()
            .toFlowable()
            .map {
                val entitles = mutableListOf<LeBonCoinEntity>()
                it.forEach { item -> entitles.add(mapper.mapFromRemote(item)) }
                entitles
            }
    }
}