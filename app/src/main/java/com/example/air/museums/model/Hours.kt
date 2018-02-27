package com.example.air.museums.model

import com.google.gson.annotations.SerializedName

data class Hours(

	@field:SerializedName("Monday")
    var monday: String? = null,

	@field:SerializedName("Thursday")
	var thursday: String? = null,

	@field:SerializedName("Friday")
	var friday: String? = null,

	@field:SerializedName("Sunday")
	var sunday: String? = null,

	@field:SerializedName("Wednesday")
	var wednesday: String? = null,

	@field:SerializedName("Tuesday")
	var tuesday: String? = null,

	@field:SerializedName("Saturday")
	var saturday: String? = null
)