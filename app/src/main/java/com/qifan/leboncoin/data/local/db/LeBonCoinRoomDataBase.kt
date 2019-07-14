package com.qifan.leboncoin.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.qifan.leboncoin.data.local.dao.LeBonCoinLocalDao
import com.qifan.leboncoin.data.local.model.LeBonCoinLocalModel

/**
 * Created by Qifan on 2019-07-14.
 */
@Database(entities = arrayOf(LeBonCoinLocalModel::class), version = 1, exportSchema = false)
abstract class LeBonCoinRoomDataBase : RoomDatabase() {
    abstract fun leboncoinLocalDao(): LeBonCoinLocalDao

    companion object {
        @Volatile
        private var INSTANCE: LeBonCoinRoomDataBase? = null

        fun getInstance(context: Context): LeBonCoinRoomDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LeBonCoinRoomDataBase::class.java, "leboncoin.db"
            )
                .build()
    }
}