package com.gamecast.utils.extensions

import android.content.res.Resources

val Int.dp: Float
    get() = (this * Resources.getSystem().displayMetrics.density)

val Int.px: Float
    get() = (this / Resources.getSystem().displayMetrics.density)