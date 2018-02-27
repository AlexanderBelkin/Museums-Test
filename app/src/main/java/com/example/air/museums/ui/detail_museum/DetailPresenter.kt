package com.example.air.museums.ui.detail_museum

import android.annotation.SuppressLint
import android.location.Geocoder
import com.example.air.museums.data.IDataManager
import com.example.air.museums.model.Hours
import com.example.air.museums.model.ScheduleModel
import com.example.air.museums.ui.base.BasePresenter
import com.example.air.museums.utils.rx.ISchedulerProvider
import com.google.android.gms.maps.model.LatLng
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DetailPresenter<V : IDetailView> @Inject
constructor(schedulerProvider: ISchedulerProvider?,
            compositeDisposable: CompositeDisposable?,
            dataManager: IDataManager?) : BasePresenter<V>(schedulerProvider!! , compositeDisposable!! , dataManager!!) , IDetailPresenter<V> {

    override fun getScheduleEntity(hours: Hours): ArrayList<ScheduleModel> {
        val scheduleEntity: ArrayList<ScheduleModel> = ArrayList()

        scheduleEntity.add(ScheduleModel("Monday", getTimeData(hours.monday!!)))
        scheduleEntity.add(ScheduleModel("Tuesday", getTimeData(hours.tuesday!!)))
        scheduleEntity.add(ScheduleModel("Wednesday", getTimeData(hours.wednesday!!)))
        scheduleEntity.add(ScheduleModel("Thursday", getTimeData(hours.thursday!!)))
        scheduleEntity.add(ScheduleModel("Friday", getTimeData(hours.friday!!)))
        scheduleEntity.add(ScheduleModel("Saturday", getTimeData(hours.saturday!!)))
        scheduleEntity.add(ScheduleModel("Sunday", getTimeData(hours.sunday!!)))

        return scheduleEntity
    }

    @SuppressLint("SimpleDateFormat")
    fun getTimeData(data: String):String{
        if (!data.equals("Closed")) {
            val listTime = data.split("-")
            val format = SimpleDateFormat("hh:mm a")
            return format.format(Date(listTime[0].toLong() * 1000)) + " - " + format.format(Date(listTime[1].toLong() * 1000))
        } else {
            return "Closed"
        }
    }

    fun getLocation(geocoder: Geocoder ,address: String): LatLng {
        try {
            val addresses = geocoder.getFromLocationName(address, 1)
            return LatLng(addresses[0].latitude, addresses[0].latitude)
        } catch (e: Exception){
            return LatLng(0.0, 0.0)
        }
    }


}