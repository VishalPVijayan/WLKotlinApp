package com.wisdomleaf.wlkotlin.networkClient

import com.wisdomleaf.wlkotlin.room.PicsumData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface Api_Interface {

    @GET
    suspend fun getPicsum(@Url url: String?): Response<List<PicsumData>>

}