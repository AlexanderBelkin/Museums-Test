package com.example.air.museums.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.air.museums.app.MuseumsApp
import com.example.air.museums.di.components.ActivityComponent
import com.example.air.museums.di.components.DaggerActivityComponent
import com.example.air.museums.di.module.ActivityModule
import com.example.air.museums.utils.NetworkUtils
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

open class BaseActivity : AppCompatActivity(), IBaseView {

    private lateinit var activityComponent : ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as MuseumsApp).getComponent())
                .build()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun getActivityComponents(): ActivityComponent {
        return activityComponent
    }

    override fun networkConnected(): Boolean {
        return NetworkUtils.networkConnected(applicationContext)
    }

    fun onFragmentAttached() {

    }

    override fun onError(resId: Int) {
        Timber.d("onError %s", getString(resId))
    }

    override fun onError(errorString: String) {
        Timber.d("onError %s", errorString)
    }

}