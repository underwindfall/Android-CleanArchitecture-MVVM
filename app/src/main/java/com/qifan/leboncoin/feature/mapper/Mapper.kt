package com.qifan.leboncoin.feature.mapper

/**
 * Created by Qifan on 2019-07-14.
 */
interface Mapper<in M, out E> {
    fun toUiModel(type: M): E
}