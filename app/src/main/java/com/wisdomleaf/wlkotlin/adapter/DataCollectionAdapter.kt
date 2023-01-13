package com.miko.wlkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wisdomleaf.wlkotlin.R
import com.wisdomleaf.wlkotlin.room.PicsumData
import com.wisdomleaf.wlkotlin.utils.AppConstants


class DataCollectionAdapter(private val mList: List<PicsumData>) :
    RecyclerView.Adapter<DataCollectionAdapter.ViewHolder>() {

    private lateinit var mlisterner: onItemClickListerner

    interface onItemClickListerner {
        fun onItemClick(position: Int)
    }

    fun setOnClickListerner(listerner: onItemClickListerner) {
        mlisterner = listerner
    }

    private var context: Context? = null
    var pos: Int = 0;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.raw_titles, parent, false)
        context = parent.context;
        return ViewHolder(view, mlisterner)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        pos = position
        Glide.with(context!!).load(ItemsViewModel.download_url).into(holder.imageBadge)
        holder.txtAuthor.text = AppConstants.author+" "+ItemsViewModel.author
        holder.txtId.text = AppConstants.id+" "+ItemsViewModel.id


    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View, listerner: onItemClickListerner) :
        RecyclerView.ViewHolder(ItemView) {
        val imageBadge: ImageView = itemView.findViewById(R.id.imageBadge)
        val txtId: TextView = itemView.findViewById(R.id.txtId)
        val txtAuthor: TextView = itemView.findViewById(R.id.txtAuthor)


        init {
            itemView.setOnClickListener {
                listerner.onItemClick(adapterPosition)
            }
        }

    }

}

