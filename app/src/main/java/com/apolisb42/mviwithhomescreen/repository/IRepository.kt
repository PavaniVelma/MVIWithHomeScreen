package com.apolisb42.mviwithhomescreen.repository

import com.apolisb42.mviwithhomescreen.model.dto.HomeData
import kotlinx.coroutines.flow.Flow

interface IRepository {

    suspend fun insertHomeData(homeData: HomeData)

    suspend fun getHomeData():Flow<List<HomeData>>
}