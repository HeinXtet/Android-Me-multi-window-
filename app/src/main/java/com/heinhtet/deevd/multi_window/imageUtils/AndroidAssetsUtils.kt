package com.heinhtet.deevd.multi_window.imageUtils

import com.heinhtet.deevd.multi_window.R

/**
 * Created by Hein Htet on 8/5/18.
 */
object AndroidAssetsUtils {
    fun headList() : ArrayList<Int> {
        var headList = ArrayList<Int>()
        headList.add(R.drawable.head1)
        headList.add(R.drawable.head2)
        headList.add(R.drawable.head3)
        headList.add(R.drawable.head4)
        headList.add(R.drawable.head5)
        headList.add(R.drawable.head6)
        headList.add(R.drawable.head7)
        headList.add(R.drawable.head8)
        headList.add(R.drawable.head9)
        headList.add(R.drawable.head10)
        headList.add(R.drawable.head11)
        headList.add(R.drawable.head12)
        return headList
    }

    fun bodyList() : ArrayList<Int> {
        var bodyList = ArrayList<Int>()
        bodyList.add(R.drawable.body1)
        bodyList.add(R.drawable.body2)
        bodyList.add(R.drawable.body3)
        bodyList.add(R.drawable.body4)
        bodyList.add(R.drawable.body5)
        bodyList.add(R.drawable.body6)
        bodyList.add(R.drawable.body7)
        bodyList.add(R.drawable.body8)
        bodyList.add(R.drawable.body9)
        bodyList.add(R.drawable.body10)
        bodyList.add(R.drawable.body11)
        bodyList.add(R.drawable.body12)
        return bodyList
    }

    fun legList() : ArrayList<Int>{
        var legList = ArrayList<Int>()
        legList.add(R.drawable.legs1)
        legList.add(R.drawable.legs2)
        legList.add(R.drawable.legs3)
        legList.add(R.drawable.legs4)
        legList.add(R.drawable.legs5)
        legList.add(R.drawable.legs6)
        legList.add(R.drawable.legs7)
        legList.add(R.drawable.legs8)
        legList.add(R.drawable.legs9)
        legList.add(R.drawable.legs10)
        legList.add(R.drawable.legs11)
        legList.add(R.drawable.legs12)
        return legList
    }

    fun all() : ArrayList<Int>{
        var bodyAll = ArrayList<Int>()
        bodyAll.addAll(headList())
        bodyAll.addAll(bodyList())
        bodyAll.addAll(legList())
        return bodyAll
    }
}
