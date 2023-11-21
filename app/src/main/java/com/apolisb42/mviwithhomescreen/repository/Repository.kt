package com.apolisb42.mviwithhomescreen.repository

import com.apolisb42.mviwithhomescreen.model.dao.HomeDao
import com.apolisb42.mviwithhomescreen.model.dto.HomeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(private val homeDao: HomeDao):IRepository {
    override suspend fun insertHomeData(homeData: HomeData) {
        homeDao.insertUser(homeData)
    }

    override suspend fun getHomeData(): Flow<List<HomeData>> {
        return flow {
            homeDao.fetchUser().apply {
                this.let{
                    emit(it)
                }.runCatching {
//                     error
                }
            }
        }
    }
}