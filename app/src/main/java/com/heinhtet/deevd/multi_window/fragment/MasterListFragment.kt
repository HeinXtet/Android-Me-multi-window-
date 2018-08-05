package com.heinhtet.deevd.multi_window.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.heinhtet.deevd.multi_window.R
import com.heinhtet.deevd.multi_window.activity.MainActivity
import com.heinhtet.deevd.multi_window.adapter.MasterListAdapter
import com.heinhtet.deevd.multi_window.adapter.SpacesItemDecoration
import kotlinx.android.synthetic.main.fragment_master_list.*

/**
 * Created by Hein Htet on 8/5/18.
 */

interface onImageClick {
    fun onImageClick(position: Int)
}

class MasterListFragment : Fragment() {

    val TAG = "masterListFragment"

    private lateinit var mCallback: onImageClick
    private lateinit var adapter: MasterListAdapter
    private lateinit var rv: RecyclerView
    private lateinit var fragmentActivity: FragmentActivity
    private lateinit var layoutManager :GridLayoutManager
    private var isLargerScreen = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.rv)
        setUpView()
        isLargerScreen = (fragmentActivity as MainActivity).isLagerScreen
    }

    private fun setUpView() {
        rv.addItemDecoration(SpacesItemDecoration(8))
        adapter = MasterListAdapter(object : onImageClick{
            override fun onImageClick(position: Int) {
                mCallback.onImageClick(position)
            }
        })
        rv.adapter = adapter

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_master_list, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mCallback = context as onImageClick
        fragmentActivity = context as FragmentActivity

    }
}