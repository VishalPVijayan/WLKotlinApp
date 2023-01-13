package com.wisdomleaf.wlkotlin.dialog

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.wisdomleaf.wlkotlin.R
import com.wisdomleaf.wlkotlin.list
import com.wisdomleaf.wlkotlin.utils.AppConstants
import com.wisdomleaf.wlkotlin.utils.GlobalVariables


class DataDialog : DialogFragment() {

    companion object {

        private var btnDismiss : ImageView? = null
        private var imageBadge : ImageView? = null
        private var txtId : TextView? = null
        private var txtAuthor : TextView? = null
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        dialog!!.window?.setGravity(Gravity.CENTER)
        dialog!!.setCanceledOnTouchOutside(false)
        return inflater.inflate(R.layout.dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDismiss = view.findViewById(R.id.btnDismiss) as ImageView
        imageBadge = view.findViewById(R.id.imageBadge) as ImageView
        txtId = view.findViewById(R.id.txtId) as TextView
        txtAuthor = view.findViewById(R.id.txtAuthor) as TextView

        txtAuthor!!.text = ""+GlobalVariables.AUTHOR_NAME
        txtId!!.text = "Tile Id "+GlobalVariables.TILE_ID
        Glide.with(requireContext()).load(GlobalVariables.IMAGE_URL).into(imageBadge!!)

        btnDismiss!!.setOnClickListener{
                dismiss()
        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    override fun onStart() {
        super.onStart()

        val width = (resources.displayMetrics.widthPixels * 0.75).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.80).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog!!.window?.setLayout(height, ViewGroup.LayoutParams.WRAP_CONTENT)

//        val width = (resources.displayMetrics.widthPixels * AppConstants.width).toInt()
//        val height = (resources.displayMetrics.heightPixels * AppConstants.height).toInt()
        dialog!!.window?.setLayout(width, height);
    }


}

