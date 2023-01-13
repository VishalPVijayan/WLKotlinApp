package com.wisdomleaf.wlkotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
abstract class RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  fun insertContentDetails(contentDetails: PicsumData)

}

