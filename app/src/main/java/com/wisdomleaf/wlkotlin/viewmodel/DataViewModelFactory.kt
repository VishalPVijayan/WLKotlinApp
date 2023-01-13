package com.miko.wlkotlin.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wisdomleaf.wlkotlin.repository.DataRepository

class DataViewModelFactory(private val dataRepository: DataRepository):ViewModelProvider.Factory {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(dataRepository) as T
    }

}