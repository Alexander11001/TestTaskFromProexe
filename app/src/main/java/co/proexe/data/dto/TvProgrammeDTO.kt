package co.proexe.data.dto

import co.proexe.domain.model.TvProgramme
import co.proexe.domain.model.TvProgrammeCategory
import com.google.gson.annotations.SerializedName
import java.util.*

data class TvProgrammeDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("category")
    val category: TvProgrammeCategory?,
    @SerializedName("isFavourite")
    val isFavourite: Boolean?,
    @SerializedName("startTime")
    val startTime: Date?,
    @SerializedName("endTime")
    val endTime: Date?,
    @SerializedName("progressPercent")
    val progressPercent: Int?
)

fun TvProgrammeDTO.toTvProgramme() = TvProgramme(
    id = this.id ?: 0,
    title = this.title ?: "Data is not available",
    imageUrl = this.imageUrl ?: "",
    type = this.type ?: "",
    category = this.category ?: TvProgrammeCategory.INFO,
    isFavourite = this.isFavourite ?: false,
    startTime = this.startTime ?: Date(),
    endTime = this.endTime ?: Date(),
    progressPercent = this.progressPercent ?: 0
)