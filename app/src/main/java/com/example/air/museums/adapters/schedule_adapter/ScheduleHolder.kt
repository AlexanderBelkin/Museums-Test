package com.example.air.museums.adapters.schedule_adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.air.museums.R

class ScheduleHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var dayId = itemView.findViewById<TextView>(R.id.day_id)
    var workTime = itemView.findViewById<TextView>(R.id.work_time)

}