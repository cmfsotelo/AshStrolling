package com.example.csotelo.ashstrolling

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currFrag = R.id.navigation_stroll
    private var dir = 0
    private var stroll = StrollFragment()
    private var about = AboutFragment()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        dir = item.itemId - currFrag
        currFrag = item.itemId
        when (item.itemId) {
            R.id.navigation_stroll -> {
                replaceFragment(stroll, R.id.content_frame)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pokedex -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_about -> {
                replaceFragment(about, R.id.content_frame)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = currFrag
    }

    inline fun FragmentManager.inTransaction(dir: Int, func: FragmentTransaction.() -> FragmentTransaction) {
        var animEnter = if (dir < 0) R.anim.enter_from_right else R.anim.enter_from_left
        var animExit = if (dir < 0) R.anim.exit_to_left else R.anim.exit_to_right
        beginTransaction().setCustomAnimations(animEnter, animExit).func().commit()
    }

    fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction(dir, { add(frameId, fragment) })
    }


    fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction(dir, { replace(frameId, fragment) })
    }


}
