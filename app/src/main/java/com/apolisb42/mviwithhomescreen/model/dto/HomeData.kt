package com.apolisb42.mviwithhomescreen.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeData(
    @PrimaryKey(autoGenerate = true)
    val userId: Int =0,
    val name:String,
    val age:String,
    val homeTown:String
)
