package com.wisdomleaf.wlkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.miko.wlkotlin.viewmodel.DataViewModel
import com.wisdomleaf.wlkotlin.database.AppDatabase
import com.wisdomleaf.wlkotlin.room.PicsumData
import com.wisdomleaf.wlkotlin.utils.GlobalVariables

var rv_dataholder: RecyclerView? = null
var container: SwipeRefreshLayout? = null
private lateinit var dataViewModel: DataViewModel
private lateinit var database: AppDatabase
var list: List<PicsumData>? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.container);
        rv_dataholder = findViewById(R.id.rv_dataholder);

        container!!.setOnRefreshListener {
            container!!.isRefreshing = false
            rv_dataholder!!.visibility = View.INVISIBLE
            fetchData()
        }

        fetchData()




    }

    private fun fetchData() {
        TODO("Not yet implemented")
    }
}