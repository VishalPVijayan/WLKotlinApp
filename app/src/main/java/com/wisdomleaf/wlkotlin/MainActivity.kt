package com.wisdomleaf.wlkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.miko.wlkotlin.adapter.DataCollectionAdapter
import com.miko.wlkotlin.viewmodel.DataViewModel
import com.miko.wlkotlin.viewmodel.DataViewModelFactory
import com.wisdomleaf.wlkotlin.database.AppDatabase
import com.wisdomleaf.wlkotlin.room.PicsumData
import com.wisdomleaf.wlkotlin.utils.AppConstants
import com.wisdomleaf.wlkotlin.utils.GlobalVariables
import com.wisdomleaf.wlkotlin.utils.MyApplication
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

var rv_dataholder: RecyclerView? = null
var container: SwipeRefreshLayout? = null
private lateinit var dataViewModel: DataViewModel
private lateinit var database: AppDatabase
var list: List<PicsumData>? = null

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
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

    @RequiresApi(Build.VERSION_CODES.M)
    private fun fetchData() {

        //Assigning BASE URL & END URL globally
        GlobalVariables.APP_BASE_URL = "https://picsum.photos/"
//        GlobalVariables.APP_END_URL = "v2/list?"
        GlobalVariables.APP_END_URL = "v2/list?page=2&limit=20"

        database =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, AppConstants.dbName)
                .build()

        val repository = (application as MyApplication).dataRepository
        dataViewModel =
            ViewModelProvider(this, DataViewModelFactory(repository))[DataViewModel::class.java]

        dataViewModel.livedata.observe(
            this
        ) {
            Log.d("MSG", "\nonCreate: $it.toString()")
        }

        GlobalScope.launch {
            val result = repository.getData();
            Log.d("NETWORK", result.toString());
        }

        database.wolfDao().getContentDetails().observe(this) {
            if (it != null) {

                list = it


                Log.d("DATABASE", it.toString())

                val adapter: DataCollectionAdapter?

                adapter = DataCollectionAdapter(list!!)
                val gridLayoutManager = GridLayoutManager(
                    applicationContext, 1, LinearLayoutManager.VERTICAL, false
                )
                rv_dataholder!!.layoutManager = gridLayoutManager

                rv_dataholder!!.visibility = View.VISIBLE
                rv_dataholder!!.adapter = adapter
                rv_dataholder!!.visibility = View.VISIBLE

                adapter!!.setOnClickListerner(object : DataCollectionAdapter.onItemClickListerner {
                    override fun onItemClick(position: Int) {


                    }
                })


            }
        }
    }
}