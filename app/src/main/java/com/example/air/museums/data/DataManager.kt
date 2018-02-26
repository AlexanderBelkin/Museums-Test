package com.example.air.museums.data

import com.example.air.museums.data.api.MuseumsApi
import com.example.air.museums.model.MuseumResponse
import io.reactivex.Observable
import javax.inject.Inject

class DataManager @Inject constructor(var retrofit: MuseumsApi) : IDataManager {

    override fun getMuseum(): Observable<ArrayList<MuseumResponse>> {
        return retrofit.getMuseumData()
    }
}