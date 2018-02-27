package com.example.air.museums.adapters.schedule_adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.air.museums.R
import com.example.air.museums.model.ScheduleModel

class ScheduleAdapter: RecyclerView.Adapter<ScheduleHolder>() {

    var data: ArrayList<ScheduleModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScheduleHolder {
        val inflatedView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.recycler_schedule_item, parent , false)
        return ScheduleHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ScheduleHolder?, position: Int) {
        holder?.dayId?.text = data[position].nameOfDay
        holder?.workTime?.text = data[position].workTime
    }

    fun setScheduleData(list: ArrayList<ScheduleModel>){
        data.clear()
        data = list
    }

}