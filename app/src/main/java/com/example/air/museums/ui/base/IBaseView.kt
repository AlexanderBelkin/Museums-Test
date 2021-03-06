package com.example.air.museums.ui.base

import android.support.annotation.StringRes


interface IBaseView {

    fun onError(errorString : String)

    fun onError(@StringRes resId: Int)

    fun networkConnected() : Boolean
}