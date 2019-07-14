package com.qifan.leboncoin.core.extension

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

/**
 * Created by Qifan on 2019-07-13.
 */
// Max cache size of glide.
private const val MAX_CACHE_SIZE = (1024 * 1024 * 512).toLong() // 512M

// The cache directory name.
private const val CACHE_FILE_NAME = "IMG_CACHE" // cache file dir name

@GlideModule(glideName = "LeBonCoinGlide")
class LeBonCoinGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        // 36MB, memory cache size
        // default value: 24MB
        val memoryCacheSize = (1024 * 1024 * 36).toLong()
        builder.setMemoryCache(LruResourceCache(memoryCacheSize))

        // Internal cache
        builder.setDiskCache(InternalCacheDiskCacheFactory(context, CACHE_FILE_NAME, MAX_CACHE_SIZE))
    }

    override fun isManifestParsingEnabled(): Boolean = false

}