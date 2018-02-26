package com.example.air.museums.data

import com.example.air.museums.data.api.MuseumsApi
import io.reactivex.Observable
import javax.inject.Inject

class DataManager @Inject constructor(var retrofit: MuseumsApi) : IDataManager {

}