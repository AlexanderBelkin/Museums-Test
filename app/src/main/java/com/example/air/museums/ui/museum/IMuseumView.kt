package com.example.air.museums.ui.museum

import com.example.air.museums.model.MuseumResponse
import com.example.air.museums.ui.base.IBaseView

interface IMuseumView: IBaseView {

    fun Success(listData: ArrayList<MuseumResponse>)

}