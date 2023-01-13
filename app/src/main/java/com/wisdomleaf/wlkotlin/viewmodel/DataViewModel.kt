package com.miko.wlkotlin.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisdomleaf.wlkotlin.repository.DataRepository
import com.wisdomleaf.wlkotlin.room.PicsumData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.M)
class DataViewModel(private val dataRepo : DataRepository) :ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            dataRepo.getData()
        }
    }

    val livedata : LiveData<PicsumData>
    get() = dataRepo.data


}