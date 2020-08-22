package com.gamecast.utils.extensions

import android.view.View
import android.view.ViewTreeObserver

fun <T> T?.or(value: T) = this ?: value

inline fun <T: View> T.waitForScroll(crossinline f: T.(listener: ViewTreeObserver.OnScrollChangedListener) -> Unit) {
    viewTreeObserver.addOnScrollChangedListener(object : ViewTreeObserver.OnScrollChangedListener {
        override fun onScrollChanged() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                f(this)
            }

        }
    })
}