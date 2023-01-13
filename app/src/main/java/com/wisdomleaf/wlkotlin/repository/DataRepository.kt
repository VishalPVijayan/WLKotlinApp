package com.wisdomleaf.wlkotlin.repository

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wisdomleaf.wlkotlin.database.AppDatabase
import com.wisdomleaf.wlkotlin.networkClient.Api_Interface
import com.wisdomleaf.wlkotlin.networkClient.RetrofitClient
import com.wisdomleaf.wlkotlin.room.PicsumData
import com.wisdomleaf.wlkotlin.utils.GlobalVariables

class DataRepository(
    private var apiInterface: Api_Interface,
    private val database: AppDatabase,
    private val applicationContext: Context
) {

    private val mutualableData = MutableLiveData<PicsumData>()
    val data: LiveData<PicsumData>
        get() = mutualableData


    @RequiresApi(Build.VERSION_CODES.M)
    suspend fun getData() {

        apiInterface = RetrofitClient.getInstance().create(Api_Interface::class.java)

        val result = apiInterface.getPicsum(GlobalVariables.APP_END_URL)
        Log.d("NETWORK", result.body().toString())
        if (result.body() != null) {
            for (i in 0 until result.body()!!.size) {
                database.wolfDao().insertContentDetails(result.body()!![i])
                Log.d(" NETWORK", result.body()!![i].toString())

            }
        } else {
            val contentdetailss = database.wolfDao().getContentDetailsOffline()
            val contentlist = contentdetailss
            for (i in 0 until contentlist.size) {
                mutualableData.postValue(contentlist[i])
                Log.d("DATABASE", "\n" + contentlist[i].toString())
            }
        }
    }

}