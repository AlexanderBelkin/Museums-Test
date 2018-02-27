package com.example.air.museums.mapper

import android.annotation.SuppressLint
import com.example.air.museums.model.Hours
import com.example.air.museums.model.MuseumResponse
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

object TimeMapper {

    fun map(data: ArrayList<MuseumResponse>): ArrayList<MuseumResponse>{
        val dataConvertable:ArrayList<MuseumResponse> = ArrayList()
        if(dataConvertable.isEmpty()){
            for (item in data) {
                item.hours?.monday = getUnixTime(item.hours?.monday!!)
                item.hours.tuesday = getUnixTime(item.hours.tuesday!!)
                item.hours.wednesday = getUnixTime(item.hours.wednesday!!)
                item.hours.thursday = getUnixTime(item.hours.thursday!!)
                item.hours.friday = getUnixTime(item.hours.friday!!)
                item.hours.saturday = getUnixTime(item.hours.saturday!!)
                item.hours.sunday = getUnixTime(item.hours.sunday!!)
                dataConvertable.add(item)
            }
        }
        return dataConvertable
    }

    @SuppressLint("SimpleDateFormat")
    fun getUnixTime(hours: String) : String {
        if (!hours.equals("Closed")) {
            val dateList = hours.split("-")
            val unixBefore: Long
            val unixFrom: Long
            unixFrom = try {
                val dateFormat = SimpleDateFormat("h:mma")
                val from = dateFormat.parse(dateList[0])
                from.time / 1000
            } catch (e: java.lang.Exception) {
                try {
                    val dateFormat = SimpleDateFormat("ha")
                    val from = dateFormat.parse(dateList[0])
                    from.time / 1000
                } catch (e: Exception) {
                    try {
                        val dateFormat = SimpleDateFormat("hha")
                        val from = dateFormat.parse(dateList[0])
                        from.time / 1000
                    } catch (e: Exception) {
                        val dateFormat = SimpleDateFormat("hh:mma")
                        val from = dateFormat.parse(dateList[0])
                        from.time / 1000
                    }
                }
            }

            unixBefore = try {
                val dateFormat = SimpleDateFormat("h:mma")
                val before = dateFormat.parse(dateList[1])
                before.time / 1000
            } catch (e: java.lang.Exception) {
                try {
                    val dateFormat = SimpleDateFormat("ha")
                    val before = dateFormat.parse(dateList[1])
                    before.time / 1000
                } catch (e: Exception) {
                    try {
                        val dateFormat = SimpleDateFormat("hha")
                        val before = dateFormat.parse(dateList[1])
                        before.time / 1000
                    } catch (e: Exception) {
                        val dateFormat = SimpleDateFormat("hh:mma")
                        val before = dateFormat.parse(dateList[1])
                        before.time / 1000
                    }
                }
            }
            return unixFrom.toString() + "-" + unixBefore.toString()
        } else {
            return "Closed"
        }
    }
}