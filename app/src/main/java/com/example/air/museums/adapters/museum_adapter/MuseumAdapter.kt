package com.example.air.museums.adapters.museum_adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.air.museums.R
import com.example.air.museums.model.MuseumResponse
import com.example.air.museums.model.ScheduleModel
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class MuseumAdapter(var callback: MuseumViewHolder.PositionCallback): RecyclerView.Adapter<MuseumViewHolder>() {

    var data: ArrayList<MuseumResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MuseumViewHolder {
        val inflatedView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.recycler_museum_item , parent , false)
        return MuseumViewHolder(inflatedView, callback)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MuseumViewHolder?, position: Int) {
        Glide.with(holder?.getContext())
                .load(data[position].image)
                .centerCrop()
                .error(R.drawable.no_data)
                .into(holder?.imageLink)
        holder?.addressPlace?.text = data[position].address
        holder?.namePlace?.text = data[position].title
        try {
            val format = SimpleDateFormat("EEEE")
            if(getStateOpened(format.format(Calendar.getInstance().time), position)) {
                holder?.badgeView?.setBackgroundResource(R.drawable.circle_view_open)
            } else {
                holder?.badgeView?.setBackgroundResource(R.drawable.circle_view_close)
            }
        } catch (e: Exception){
            holder?.badgeView?.setBackgroundResource(R.drawable.circle_view_close)
        }
    }

    fun setMuseumData(list: ArrayList<MuseumResponse>){
        data.clear()
        data.addAll(list)
    }

    fun getStateOpened(dayOfWeek: String, position: Int) : Boolean{
        when(dayOfWeek){
            "Monday" -> return getState(data[position].hours?.monday!!)
            "Tuesday" -> return getState(data[position].hours?.tuesday!!)
            "Wednesday" -> return getState(data[position].hours?.wednesday!!)
            "Thursday" -> return getState(data[position].hours?.thursday!!)
            "Friday" -> return getState(data[position].hours?.friday!!)
            "Saturday" -> return getState(data[position].hours?.saturday!!)
            "Sunday" -> return getState(data[position].hours?.sunday!!)
        }
        return false
    }

    fun getState(timeOpened: String): Boolean{
        if(!timeOpened.equals("Closed")) {
            val listData = timeOpened.split("-")
            var currentTime = Date()
            try {
                val format = SimpleDateFormat("hh:mm a")
                currentTime = format.parse(format.format(Calendar.getInstance().time))

            } catch (e: Exception){
                Timber.d(e.stackTrace.toString())
            }
            return currentTime.time / 1000 > listData[0].toLong() &&
                    currentTime.time / 1000 < listData[1].toLong()
        } else {
            return false
        }
    }

}