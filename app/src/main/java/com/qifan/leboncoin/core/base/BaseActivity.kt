package com.qifan.leboncoin.core.base

import android.os.Bundle
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

    abstract fun getLayoutId(): Int
}