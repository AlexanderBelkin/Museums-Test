package com.example.air.museums.ui.museum

import com.example.air.museums.data.IDataManager
import com.example.air.museums.ui.base.BasePresenter
import com.example.air.museums.utils.rx.ISchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MuseumPresenter<V : IMuseumView> @Inject
    constructor(schedulerProvider: ISchedulerProvider?,
    compositeDisposable: CompositeDisposable?,
    dataManager: IDataManager?) : BasePresenter<V>(schedulerProvider!! , compositeDisposable!! , dataManager!!) , IMuseumPresenter<V> {


    override fun getMuseumData() {
        dataManager.getMuseum()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ listData ->
                    mvpView?.Success(listData)
                }, {
                    throwable: Throwable -> mvpView?.onError(throwable.stackTrace.toString())
                })
    }
}