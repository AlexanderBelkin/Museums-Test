package com.example.air.museums.model

import com.google.gson.annotations.SerializedName

data class MuseumResponse(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("hours")
	val hours: Hours? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)