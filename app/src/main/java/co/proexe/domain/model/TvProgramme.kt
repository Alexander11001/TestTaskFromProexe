package co.proexe.domain.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class TvProgramme(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val type: String,
    val category: TvProgrammeCategory,
    val isFavourite: Boolean,
    val startTime: Date,
    val endTime: Date,
    val progressPercent: Int
)