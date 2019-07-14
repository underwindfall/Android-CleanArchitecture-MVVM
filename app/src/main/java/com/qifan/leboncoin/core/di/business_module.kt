package com.qifan.leboncoin.core.di

import com.qifan.leboncoin.data.local.LeBonCoinLocalDataSource
import com.qifan.leboncoin.data.mapper.list.LeBonCoinEntityMapper
import com.qifan.leboncoin.data.remote.LeBonCoinRemoteDataSource
import com.qifan.leboncoin.domain.interactor.GetLeBonCoinDataUseCase
import com.qifan.leboncoin.domain.repository.GetLeBonCoinRepository
import com.qifan.leboncoin.domain.source.LeBonCoinDataStore
import com.qifan.leboncoin.domain.source.LeBonCoinDataStoreFactory
import com.qifan.leboncoin.feature.list.mapper.LeBonCoinMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Qifan on 2019-07-13.
 */
val domainModule = module {
    factory {
        LeBonCoinDataStoreFactory(get(named("local")), get(named("remote")))
    }

    factory { GetLeBonCoinRepository(get()) }
    factory { GetLeBonCoinDataUseCase(get(), get(), get()) }
}

val dataModule = module {
    factory {
        LeBonCoinEntityMapper()
    }
    factory<LeBonCoinDataStore>(named("remote")) {
        LeBonCoinRemoteDataSource(get(), get())
    }
    factory<LeBonCoinDataStore>(named("local")) {
        LeBonCoinLocalDataSource()
    }
}

val presentationModule = module {
    factory {
        LeBonCoinMapper()
    }
}