package com.wisdomleaf.wlkotlin.utils

import android.app.Application
import com.wisdomleaf.wlkotlin.database.AppDatabase
import com.wisdomleaf.wlkotlin.networkClient.Api_Interface
import com.wisdomleaf.wlkotlin.networkClient.RetrofitClient
import com.wisdomleaf.wlkotlin.repository.DataRepository


class MyApplication : Application() {
    lateinit var dataRepository: DataRepository
    override fun onCreate() {
        super.onCreate()

        val apiInterface = RetrofitClient.getInstance().create(Api_Interface::class.java)
        val database = AppDatabase.getDatabase(applicationContext)
        dataRepository = DataRepository(apiInterface, database,applicationContext)

    }

}