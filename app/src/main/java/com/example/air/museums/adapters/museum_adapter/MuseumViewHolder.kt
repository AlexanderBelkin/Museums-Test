package com.example.air.museums.adapters.museum_adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.air.museums.R

class MuseumViewHolder internal constructor(itemView: View,
                                            var callback: PositionCallback) : RecyclerView.ViewHolder(itemView), View.OnClickListener  {

    var imageLink = itemView.findViewById<ImageView>(R.id.image_museum)
    var addressPlace = itemView.findViewById<TextView>(R.id.address_place)
    var namePlace = itemView.findViewById<TextView>(R.id.name_place)
    var badgeView = itemView.findViewById<View>(R.id.badge_opened)

    init {
        itemView.setOnClickListener(this)
    }

    fun getContext(): Context {
        return itemView.context
    }

    @SuppressLint("LogNotTimber")
    override fun onClick(v: View?) {
        callback.getPosition(position)
    }

    interface PositionCallback{

        fun getPosition(position: Int)

    }

}