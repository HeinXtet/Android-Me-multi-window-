package com.heinhtet.deevd.multi_window.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.heinhtet.deevd.multi_window.R
import com.heinhtet.deevd.multi_window.fragment.BodyPartsFragment
import com.heinhtet.deevd.multi_window.fragment.onImageClick
import com.heinhtet.deevd.multi_window.imageUtils.AndroidAssetsUtils
import kotlinx.android.synthetic.main.fragment_master_list.*

/**
 * Created by Hein Htet on 8/5/18.
 */

class MainActivity : AppCompatActivity(), onImageClick {


    private var headIndex = 0
    private var bodyIndex = 0
    private var legIndex = 0
    var isLagerScreen = false
    val TAG = "Main"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isLagerScreen = findViewById<LinearLayout>(R.id.linear) != null
        if (isLagerScreen) {
            setUpViewForLargerView()
        } else {
            setUpViewForNormal()
        }
    }


    private fun setUpViewForLargerView() {
        nextBtn.visibility = View.GONE
        rv.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        addFragements()

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


    private fun setUpViewForNormal() {
        rv.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
    }

    override fun onImageClick(position: Int) {
        Log.i(TAG, " image position $position")
        var bodyPartId = position / 12
        var index = position - 12 * bodyPartId
        if (isLagerScreen) {
            var newBodyPartsFragment = BodyPartsFragment()
            when(bodyPartId){
                0 ->{
                    newBodyPartsFragment.setImageListIds(AndroidAssetsUtils.headList())
                    newBodyPartsFragment.setListIndex(index)
                    fragmentTransaction(newBodyPartsFragment,R.id.head_frame)
                }
                1 ->{
                    newBodyPartsFragment.setImageListIds(AndroidAssetsUtils.bodyList())
                    newBodyPartsFragment.setListIndex(index)
                    fragmentTransaction(newBodyPartsFragment,R.id.body_frame)
                }

                2 ->{
                    newBodyPartsFragment.setImageListIds(AndroidAssetsUtils.legList())
                    newBodyPartsFragment.setListIndex(index)
                    fragmentTransaction(newBodyPartsFragment,R.id.leg_frame)
                }
            }

        } else {
            when (bodyPartId) {
                0 -> {
                    headIndex = index
                    alertImage("Head")
                }
                1 -> {
                    bodyIndex = index
                    alertImage("Body")

                }
                2 -> {
                    legIndex = index
                    alertImage("Leg")
                }
            }
            var bundle = Bundle()
            bundle.putInt("headIndex", headIndex)
            bundle.putInt("bodyIndex", bodyIndex)
            bundle.putInt("legIndex", legIndex)

            nextBtn.setOnClickListener {
                startActivity(Intent(this@MainActivity, AndroidMeActivity::class.java).putExtras(bundle))

            }
        }


    }

    private fun alertImage(message: String) {
        Toast.makeText(this, "You Choose $message Path", Toast.LENGTH_SHORT).show()
    }


}