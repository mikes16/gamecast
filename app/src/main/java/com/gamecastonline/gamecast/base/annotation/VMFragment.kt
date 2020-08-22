package com.gamecastonline.gamecast.base.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class VMFragment(val layoutId: Int, val title: Int = 0)