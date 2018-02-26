package com.example.air.museums.data

import com.example.air.museums.model.MuseumResponse
import io.reactivex.Observable

interface IDataManager {

    fun getMuseum(): Observable<ArrayList<MuseumResponse>>

}