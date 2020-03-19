package com.github.jobs.android.data.model.api.jobs

import com.github.jobs.android.data.model.BaseResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JobsResponse(

        @SerializedName("company_logo")
        @Expose
        val companyLogo: String?,

        @SerializedName("how_to_apply")
        @Expose
        val howToApply: String?,

        @SerializedName("created_at")
        @Expose
        val createdAt: String?,

        @SerializedName("description")
        @Expose
        val description: String?,

        @SerializedName("location")
        @Expose
        val location: String?,

        @SerializedName("company")
        @Expose
        val company: String?,

        @SerializedName("company_url")
        @Expose
        val companyUrl: String?,

        @SerializedName("id")
        @Expose
        val id: String?,

        @SerializedName("title")
        @Expose
        val title: String?,

        @SerializedName("type")
        @Expose
        val type: String?,

        @SerializedName("url")
        @Expose
        val url: String?
) : BaseResponse()