package com.qifan.leboncoin.data.mapper

/**
 * Created by Qifan on 2019-07-14.
 */

interface EntityMapper<in M, out E> {
    fun mapFromRemote(type: M): E
}