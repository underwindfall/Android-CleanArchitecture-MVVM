package com.qifan.leboncoin.data.mapper.list

import com.qifan.leboncoin.data.local.model.LeBonCoinLocalModel
import com.qifan.leboncoin.data.mapper.EntityLocalMapper
import com.qifan.leboncoin.domain.entity.LeBonCoinEntity

/**
 * Created by Qifan on 2019-07-14.
 */
class LeBonCoinLocalEntityMapper : EntityLocalMapper<LeBonCoinLocalModel, LeBonCoinEntity> {
    override fun mapFromLocal(type: LeBonCoinLocalModel): LeBonCoinEntity {
        return LeBonCoinEntity(
            id = type.id,
            albumId = type.albumId,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }

    override fun mapToLocal(type: LeBonCoinEntity): LeBonCoinLocalModel {
        return LeBonCoinLocalModel(
            id = type.id,
            albumId = type.albumId,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }
}