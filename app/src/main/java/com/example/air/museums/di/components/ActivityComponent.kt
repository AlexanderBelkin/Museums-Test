package com.example.air.museums.di.components

import com.example.air.museums.di.ActivityScope
import com.example.air.museums.di.module.ActivityModule
import com.example.air.museums.ui.detail_museum.DetaileActivity
import com.example.air.museums.ui.museum.MuseumActivity
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class) , modules = arrayOf(ActivityModule::class))
interface ActivityComponent  {

    fun inject(activity: MuseumActivity)
    fun inject(activity: DetaileActivity)

}