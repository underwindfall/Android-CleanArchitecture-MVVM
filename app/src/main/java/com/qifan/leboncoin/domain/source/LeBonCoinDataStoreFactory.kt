package com.qifan.leboncoin.domain.source

/**
 * Created by Qifan on 2019-07-14.
 */
class LeBonCoinDataStoreFactory(
    private val localDataStore: LeBonCoinDataStore,
    private val remoteDataStore: LeBonCoinDataStore
) {

    fun getDataStore(isCached: Boolean): LeBonCoinDataStore {
        return if (isCached) localDataStore else remoteDataStore
    }

    fun getLocalDataStore(): LeBonCoinDataStore = localDataStore

    fun getRemoteDataStore(): LeBonCoinDataStore = remoteDataStore
}