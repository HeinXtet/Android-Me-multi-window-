package com.heinhtet.deevd.multi_window.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.heinhtet.deevd.multi_window.R
import com.heinhtet.deevd.multi_window.imageUtils.AndroidAssetsUtils

/**
 * Created by Hein Htet on 8/5/18.
 */

class BodyPartsFragment : Fragment(), View.OnClickListener {


    override fun onClick(v: View?) {
        if (mListIndex == mImageListId.size - 1) {
            mListIndex = 0
        } else {
            mListIndex++
        }
        setImage(mListIndex)
    }


    private lateinit var mImageListId: ArrayList<Int>
    private var mListIndex = 0
    private lateinit var iv: ImageView


    fun BodyPartsFragment() {
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.body_part_iv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv = view.findViewById(R.id.iv)
        iv.setOnClickListener(this)
        if (savedInstanceState!=null){
            mImageListId = savedInstanceState.getIntegerArrayList("imageIdList")
            mListIndex = savedInstanceState.getInt("lastIndex")

        }
        setImage(mListIndex)
    }

    fun setListIndex(index: Int) {
        this.mListIndex = index
    }

    fun setImageListIds(list: ArrayList<Int>) {
        this.mImageListId = list
    }


    private fun setImage(index: Int) {
        iv.setImageResource(mImageListId[index])
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList("imageIdList",mImageListId)
        outState.putInt("lastIndex",mListIndex)
    }


}