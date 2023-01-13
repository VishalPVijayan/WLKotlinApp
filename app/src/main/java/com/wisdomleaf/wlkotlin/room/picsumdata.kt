package com.wisdomleaf.wlkotlin.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wisdomleaf.wlkotlin.utils.AppConstants

@Entity(tableName = AppConstants.tableName)
data class PicsumData(

    @PrimaryKey
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val download_url: String?,
    val url: String

)