package com.heinhtet.deevd.multi_window.adapter

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.heinhtet.deevd.multi_window.R
import com.heinhtet.deevd.multi_window.imageUtils.AndroidAssetsUtils
import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import com.heinhtet.deevd.multi_window.fragment.onImageClick

/**
 * Created by Hein Htet on 8/5/18.
 */

class MasterListAdapter(var callback : onImageClick):RecyclerView.Adapter<MasterListAdapter.VH>() {

   private var list = AndroidAssetsUtils.all()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var vh =  VH(LayoutInflater.from(parent.context).inflate(R.layout.grid_iv, parent, false))
        return vh
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var iv = list[position]
        holder.onBind(iv)
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv = itemView.findViewById<ImageView>(R.id.iv)

        fun onBind(int: Int) {
            iv.setImageResource(int)
            itemView.setOnClickListener{
                callback.onImageClick(adapterPosition)
            }
        }
    }
}