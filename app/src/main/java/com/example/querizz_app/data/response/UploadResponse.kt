package com.example.querizz_app.data.response

import com.google.gson.annotations.SerializedName

data class UploadResponse(

	@field:SerializedName("error")
	val error: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)
