package com.qifan.leboncoin.feature.list

import com.qifan.leboncoin.core.NetWorkState
import com.qifan.leboncoin.core.base.BaseViewModel
import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import com.qifan.leboncoin.domain.interactor.GetLeBonCoinDataUseCase
import com.qifan.leboncoin.feature.list.mapper.LeBonCoinMapper
import com.qifan.leboncoin.feature.list.model.LeBonCoin
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor

/**
 * Created by Qifan on 2019-07-13.
 */
class ListViewModel(
    private val getLeBonCoinDataUseCase: GetLeBonCoinDataUseCase,
    private val mapper: LeBonCoinMapper
) : BaseViewModel() {
    private val network: BehaviorProcessor<NetWorkState> = BehaviorProcessor.createDefault(NetWorkState.LOADING)
    private val entityList: BehaviorProcessor<List<LeBonCoinEntity>> = BehaviorProcessor.createDefault(emptyList())

    val networkStatus: Flowable<NetWorkState> = network.share()
        .replay(1)
        .autoConnect()
        .distinctUntilChanged()

    val dataList: Flowable<List<LeBonCoin>> = entityList
        .filter { it.isNotEmpty() }
        .map {
            val data = mutableListOf<LeBonCoin>()
            it.forEach { item -> data.add(mapper.toUiModel(item)) }
            data
        }

    fun loadData() {
        network.onNext(NetWorkState.LOADING)
        val disposable = getLeBonCoinDataUseCase.execute()
            .subscribe({
                network.onNext(NetWorkState.SUCCESS)
                entityList.onNext(it)
            }, {
                network.onNext(NetWorkState.FAIL)
            })
        addDisposable(disposable)
    }

}