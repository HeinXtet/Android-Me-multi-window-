package com.heinhtet.deevd.multi_window.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.heinhtet.deevd.multi_window.R
import com.heinhtet.deevd.multi_window.fragment.BodyPartsFragment
import com.heinhtet.deevd.multi_window.imageUtils.AndroidAssetsUtils

class AndroidMeActivity : AppCompatActivity() {


    private var headIndex = 0
    private var bodyIndex = 0
    private var legIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.android_me_activity)
        if (savedInstanceState == null) {
            addFragements()
        }
    }


    private fun addFragements() {

        if (intent.extras != null) {
            var indexBundle = intent.extras
            headIndex = indexBundle.get("headIndex") as Int
            bodyIndex = indexBundle.get("bodyIndex") as Int
            legIndex = indexBundle.get("legIndex") as Int
        }

        //head part Fragment
        var headBodyFragment = BodyPartsFragment()
        headBodyFragment.setImageListIds(AndroidAssetsUtils.headList())
        headBodyFragment.setListIndex(headIndex)
        fragmentTransaction(headBodyFragment, R.id.head_frame)


        //body part fragment
        var bodyBodyPartsFragment = BodyPartsFragment()
        bodyBodyPartsFragment.setImageListIds(AndroidAssetsUtils.bodyList())
        bodyBodyPartsFragment.setListIndex(bodyIndex)
        fragmentTransaction(bodyBodyPartsFragment, R.id.body_frame)


        //leg parts fragment
        var legPartFragment = BodyPartsFragment()
        legPartFragment.setImageListIds(AndroidAssetsUtils.legList())
        legPartFragment.setListIndex(legIndex)
        fragmentTransaction(legPartFragment, R.id.leg_frame)
    }


    private fun fragmentTransaction(fragment: Fragment, id: Int) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        ft.add(id, fragment).commit()
    }


}
