package com.qifan.leboncoin.core.di

import com.google.gson.GsonBuilder
import com.qifan.leboncoin.BuildConfig
import com.qifan.leboncoin.core.BASE_URL
import com.qifan.leboncoin.core.OK_HTTP_CACHE_SIZE
import com.qifan.leboncoin.data.remote.LeBonCoinService
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Qifan on 2019-07-13.
 */

val networkModule = module {

    single { Cache(androidApplication().cacheDir, OK_HTTP_CACHE_SIZE) }

    single { GsonBuilder().create() }

    single {
        OkHttpClient.Builder().apply {
            cache(get())
            addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
        }.build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }

    single<LeBonCoinService> {
        get<Retrofit>().create(LeBonCoinService::class.java)
    }
}