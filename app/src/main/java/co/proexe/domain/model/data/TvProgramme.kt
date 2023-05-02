package co.proexe.domain.model.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class TvProgramme(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("category")
    val category: TvProgrammeCategory,
    @SerializedName("isFavourite")
    val isFavourite: Boolean,
    @SerializedName("startTime")
    val startTime: Date,
    @SerializedName("endTime")
    val endTime: Date,
    @SerializedName("progressPercent")
    val progressPercent: Int
)