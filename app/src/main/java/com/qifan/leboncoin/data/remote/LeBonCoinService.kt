package com.qifan.leboncoin.data.remote

import com.qifan.leboncoin.data.remote.model.LeBonCoinRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Qifan on 2019-07-13.
 */
interface LeBonCoinService {
    @GET("photos")
    fun getData(): Single<List<LeBonCoinRemoteModel>>
}