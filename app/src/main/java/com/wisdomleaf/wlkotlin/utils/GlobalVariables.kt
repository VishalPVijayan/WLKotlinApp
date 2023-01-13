package com.wisdomleaf.wlkotlin.utils

import android.app.Application

class GlobalVariables : Application(){

    companion object {

        @JvmField
        var APP_BASE_URL: String? = null

        @JvmField
        var APP_END_URL: String? = null

        @JvmField
        var AUTHOR_NAME: String? = null

        @JvmField
        var TILE_ID: String? = null

        @JvmField
        var IMAGE_URL: String? = null

    }

}