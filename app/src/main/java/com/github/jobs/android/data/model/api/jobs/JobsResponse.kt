package com.github.jobs.android.data.model.api.jobs

import com.github.jobs.android.data.model.BaseResponse
import com.google.gson.annotations.SerializedName

data class JobsResponse(

	@field:SerializedName("company_logo")
	val companyLogo: Any?,

	@field:SerializedName("how_to_apply")
	val howToApply: String?,

	@field:SerializedName("created_at")
	val createdAt: String?,

	@field:SerializedName("description")
	val description: String?,

	@field:SerializedName("location")
	val location: String?,

	@field:SerializedName("company")
	val company: String?,

	@field:SerializedName("company_url")
	val companyUrl: Any?,

	@field:SerializedName("id")
	val id: String?,

	@field:SerializedName("title")
	val title: String?,

	@field:SerializedName("type")
	val type: String?,

	@field:SerializedName("url")
	val url: String?
): BaseResponse()