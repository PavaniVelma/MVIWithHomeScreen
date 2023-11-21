package com.apolisb42.mviwithhomescreen.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apolisb42.mviwithhomescreen.model.Constants.HOME_DATA
import com.apolisb42.mviwithhomescreen.model.dto.HomeData

@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(homeData: HomeData):Long

    @Query("SELECT * FROM $HOME_DATA")
   suspend  fun fetchUser():List<HomeData>
}