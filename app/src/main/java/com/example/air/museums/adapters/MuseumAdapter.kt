package com.example.air.museums.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.air.museums.R
import com.example.air.museums.model.MuseumResponse

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
                .into(holder?.imageLink)
        holder?.addressPlace?.text = data[position].address
        holder?.namePlace?.text = data[position].title
    }

    fun setMuseumData(list: ArrayList<MuseumResponse>){
        data.clear()
        data.addAll(list)
    }

}