package com.example.air.museums.di.module

import android.support.v7.app.AppCompatActivity
import com.example.air.museums.di.ActivityScope
import com.example.air.museums.ui.museum.IMuseumPresenter
import com.example.air.museums.ui.museum.IMuseumView
import com.example.air.museums.ui.museum.MuseumPresenter
import com.example.air.museums.utils.rx.AppSchedulerProvider
import com.example.air.museums.utils.rx.ISchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideContext(): AppCompatActivity {
        return mActivity
    }

    @Provides
    @ActivityScope
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ActivityScope
    fun provideSchedulerProvide(): ISchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @ActivityScope
    fun provideMainPresenter(presenter: MuseumPresenter<IMuseumView>): IMuseumPresenter<IMuseumView> {
        return presenter
    }

}