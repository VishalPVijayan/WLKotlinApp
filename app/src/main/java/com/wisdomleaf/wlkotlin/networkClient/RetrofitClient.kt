package com.wisdomleaf.wlkotlin.networkClient

import com.wisdomleaf.wlkotlin.utils.GlobalVariables
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient : Interceptor {
    fun getInstance() : Retrofit {

        GlobalVariables.APP_BASE_URL = "https://picsum.photos/"
//        GlobalVariables.APP_END_URL = "v2/list?"
        GlobalVariables.APP_END_URL = "v2/list?page=2&limit=20"

        return Retrofit.Builder()
            .baseUrl("https://picsum.photos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain!!.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "*/*")
            .build()

        return chain.proceed(request)
    }
}