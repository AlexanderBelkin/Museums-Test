package com.example.air.museums.di.components

import android.content.Context
import com.example.air.museums.app.MuseumsApp
import com.example.air.museums.data.IDataManager
import com.example.air.museums.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {

    fun inject(app: MuseumsApp)

    fun context(): Context

    fun dataManager(): IDataManager

    fun application(): MuseumsApp
}