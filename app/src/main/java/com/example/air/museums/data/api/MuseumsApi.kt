package com.example.air.museums.data.api

import com.example.air.museums.model.MuseumResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface MuseumsApi {

    @GET("bins/1vhe1")
    fun getMuseumData(): Observable<ArrayList<MuseumResponse>>

}