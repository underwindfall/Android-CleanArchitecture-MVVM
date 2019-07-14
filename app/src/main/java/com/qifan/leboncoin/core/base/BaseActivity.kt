package com.qifan.leboncoin.core.base

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.qifan.leboncoin.core.behaviors.BehaviorConsumer

/**
 * Created by Qifan on 2019-07-13.
 */
abstract class BaseActivity : AppCompatActivity(), BehaviorConsumer {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.consumeBehaviors()
        setContentView(getLayoutId())
    }

    override fun onDestroy() {
        lifecycle.clearBehaviors()
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val menuId = getMenuId()
        return menuId?.let {
            menuInflater.inflate(menuId, menu)
            true
        } ?: false
    }

    abstract fun getLayoutId(): Int
    abstract fun getMenuId(): Int?
}