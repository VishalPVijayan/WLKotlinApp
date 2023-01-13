package com.wisdomleaf.wlkotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wisdomleaf.wlkotlin.room.PicsumData
import com.wisdomleaf.wlkotlin.room.RoomDao
import com.wisdomleaf.wlkotlin.utils.AppConstants

@Database(entities = [PicsumData :: class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wolfDao() : RoomDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context, AppDatabase::class.java, AppConstants.dbName
                ).build()
            }
            return INSTANCE!!
        }
    }
}

