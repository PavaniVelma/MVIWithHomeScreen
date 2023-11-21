package com.apolisb42.mviwithhomescreen.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apolisb42.mviwithhomescreen.model.dao.HomeDao
import com.apolisb42.mviwithhomescreen.model.dto.HomeData


@Database(entities = [HomeData::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getHomeData() : HomeDao

    companion object{
        private const val DB_NAME = "database"
        private var databaseInstance:AppDatabase?=null

        fun getAppDatabase(context: Context):AppDatabase?{
            if(databaseInstance == null){
                databaseInstance = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return databaseInstance
        }
    }
}