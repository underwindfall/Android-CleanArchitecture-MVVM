package com.qifan.leboncoin.feature.list.mapper

import com.qifan.leboncoin.domain.entity.LeBonCoinEntity
import com.qifan.leboncoin.feature.list.model.LeBonCoin
import com.qifan.leboncoin.feature.mapper.Mapper

/**
 * Created by Qifan on 2019-07-14.
 */
class LeBonCoinMapper : Mapper<LeBonCoinEntity, LeBonCoin> {
    override fun toUiModel(type: LeBonCoinEntity): LeBonCoin = LeBonCoin(
        id = type.id,
        albumId = type.albumId,
        title = type.title,
        url = type.url,
        thumbnailUrl = type.thumbnailUrl
    )
}