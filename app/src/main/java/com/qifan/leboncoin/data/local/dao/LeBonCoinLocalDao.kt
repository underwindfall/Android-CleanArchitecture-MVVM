package com.qifan.leboncoin.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qifan.leboncoin.data.local.model.LeBonCoinLocalModel
import io.reactivex.Flowable

/**
 * Created by Qifan on 2019-07-14.
 */

@Dao
interface LeBonCoinLocalDao {

    @Query("SELECT * FROM leboncoin_table")
    fun getAll(): Flowable<List<LeBonCoinLocalModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(model: LeBonCoinLocalModel)


    @Query("DELETE FROM leboncoin_table")
    fun deleteAll()
}