package com.example.air.museums.ui.detail_museum

import com.example.air.museums.model.Hours
import com.example.air.museums.model.ScheduleModel
import com.example.air.museums.ui.base.IBasePresenter

interface IDetailPresenter<in V: IDetailView>: IBasePresenter<V> {

    fun getScheduleEntity(hours: Hours): ArrayList<ScheduleModel>

}