package com.qifan.leboncoin.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Qifan on 2019-07-13.
 */
data class LeBonCoinRemoteModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)