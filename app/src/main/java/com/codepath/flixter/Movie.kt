package com.codepath.flixter

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Movie (
    @SerializedName("title")
    var title: String? = null,

    @SerializedName("release_date")
    var release: String? = null,

    @SerializedName("poster_path")
    var posterImageUrl: String? = null,

    @SerializedName("overview")
    var overview: String? = null,

    @SerializedName("vote_average")
    var rating: String? = null

) : java.io.Serializable