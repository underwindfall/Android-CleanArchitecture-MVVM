package com.qifan.leboncoin.data.mapper.list

import com.qifan.leboncoin.data.mapper.EntityMapper
import com.qifan.leboncoin.data.remote.model.LeBonCoinRemoteModel
import com.qifan.leboncoin.domain.entity.LeBonCoinEntity

/**
 * Created by Qifan on 2019-07-14.
 */
class LeBonCoinEntityMapper : EntityMapper<LeBonCoinRemoteModel, LeBonCoinEntity> {
    override fun mapFromRemote(type: LeBonCoinRemoteModel): LeBonCoinEntity {
        return LeBonCoinEntity(
            id = type.id,
            albumId = type.albumId,
            title = type.title,
            url = type.url,
            thumbnailUrl = type.thumbnailUrl
        )
    }
}