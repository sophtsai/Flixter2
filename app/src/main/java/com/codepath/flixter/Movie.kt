package com.codepath.flixter

import com.google.gson.annotations.SerializedName

class Movie {
    @JvmField
    @SerializedName("title")
    var title: String? = null

    @JvmField
    @SerializedName("release_date")
    var release: String? = null

    @SerializedName("poster_path")
    var posterImageUrl: String? = null

    @SerializedName("overview")
    var overview: String? = null

}