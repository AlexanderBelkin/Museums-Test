package com.example.air.museums.ui.museum

import com.example.air.museums.data.IDataManager
import com.example.air.museums.ui.base.BasePresenter
import com.example.air.museums.utils.rx.ISchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MuseumPresenter<V : IMuseumView> @Inject
    constructor(schedulerProvider: ISchedulerProvider?,
    compositeDisposable: CompositeDisposable?,
    dataManager: IDataManager?) : BasePresenter<V>(schedulerProvider!! , compositeDisposable!! , dataManager!!) , IMuseumPresenter<V> {

}