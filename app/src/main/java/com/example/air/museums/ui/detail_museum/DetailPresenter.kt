package com.example.air.museums.ui.detail_museum

import com.example.air.museums.data.IDataManager
import com.example.air.museums.model.Hours
import com.example.air.museums.model.ScheduleModel
import com.example.air.museums.ui.base.BasePresenter
import com.example.air.museums.utils.rx.ISchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailPresenter<V : IDetailView> @Inject
constructor(schedulerProvider: ISchedulerProvider?,
            compositeDisposable: CompositeDisposable?,
            dataManager: IDataManager?) : BasePresenter<V>(schedulerProvider!! , compositeDisposable!! , dataManager!!) , IDetailPresenter<V> {

    override fun getScheduleEntity(hours: Hours): ArrayList<ScheduleModel> {
        val scheduleEntity: ArrayList<ScheduleModel> = ArrayList()

        scheduleEntity.add(ScheduleModel("Monday", hours.monday!!))
        scheduleEntity.add(ScheduleModel("Tuesday", hours.tuesday!!))
        scheduleEntity.add(ScheduleModel("Wednesday", hours.wednesday!!))
        scheduleEntity.add(ScheduleModel("Thursday", hours.thursday!!))
        scheduleEntity.add(ScheduleModel("Friday", hours.friday!!))
        scheduleEntity.add(ScheduleModel("Saturday", hours.saturday!!))
        scheduleEntity.add(ScheduleModel("Sunday", hours.sunday!!))

        return scheduleEntity
    }
}