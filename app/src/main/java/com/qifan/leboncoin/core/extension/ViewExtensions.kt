package com.qifan.leboncoin.core.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.snackbar.Snackbar
import com.qifan.leboncoin.R

/**
 * Created by Qifan on 2019-07-13.
 */
fun ViewGroup.inflateLayout(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}


fun AppCompatImageView.loadImage(url: String?) {
    LeBonCoinGlide.with(context)
        .asBitmap()
        .load(url)
        .placeholder(R.drawable.placeholder)
        .centerCrop()
        .error(R.drawable.placeholder)
        .into(this)
}

inline fun View.snack(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    snack(resources.getString(messageRes), length, f)
}

inline fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}