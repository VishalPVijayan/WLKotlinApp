package com.wisdomleaf.wlkotlin.utils

import android.app.Application

class GlobalVariables : Application(){

    companion object {

        @JvmField
        var APP_BASE_URL: String? = null

        @JvmField
        var APP_END_URL: String? = null





    }

}