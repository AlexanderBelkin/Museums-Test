package com.example.air.museums.ui.museum

import com.example.air.museums.model.MuseumResponse
import com.example.air.museums.ui.base.IBasePresenter

interface IMuseumPresenter<in V: IMuseumView>: IBasePresenter<V> {

    fun getMuseumData()

    fun getSelectedItem(position: Int): MuseumResponse

}