package com.heinhtet.deevd.multi_window.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * Created by Hein Htet on 8/5/18.

 */

class SpacesItemDecoration(space: Int) : RecyclerView.ItemDecoration() {

    private val halfSpace: Int

    init {
        this.halfSpace = space / 2
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {

        if (parent.paddingLeft != halfSpace) {
            parent.setPadding(halfSpace, halfSpace, halfSpace, halfSpace)
            parent.clipToPadding = false
        }

        outRect.top = halfSpace
        outRect.bottom = halfSpace
        outRect.left = halfSpace
        outRect.right = halfSpace
    }
}