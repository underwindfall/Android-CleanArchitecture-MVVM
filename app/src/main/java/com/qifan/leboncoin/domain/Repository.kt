package com.qifan.leboncoin.domain

import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */
interface Repository<T> {
    fun clearData(): Completable
    fun saveData(data: List<T>): Completable
    fun getData(): Flowable<List<T>>
}