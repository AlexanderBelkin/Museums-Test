package com.example.air.museums.app

import android.app.Application
import android.content.ContextWrapper
import com.androidnetworking.AndroidNetworking
import com.example.air.museums.di.components.ApplicationComponent
import com.example.air.museums.di.components.DaggerApplicationComponent
import com.example.air.museums.di.module.AppModule
import com.facebook.stetho.Stetho
import com.pixplicity.easyprefs.library.Prefs
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class MuseumsApp : Application() {

    @Inject
    lateinit var calligraphyConfig: CalligraphyConfig

    private lateinit var appComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this)).build()

        appComponent.inject(this)
        Timber.plant(Timber.DebugTree())
        AndroidNetworking.initialize(applicationContext)
        CalligraphyConfig.initDefault(calligraphyConfig)
        Stetho.initializeWithDefaults(this)
        Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(packageName)
                .setUseDefaultSharedPreference(true)
                .build()
    }

    fun getComponent() : ApplicationComponent {
        return appComponent
    }


}