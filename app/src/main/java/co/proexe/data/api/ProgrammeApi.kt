package co.proexe.data.api

import co.proexe.data.dto.TvProgrammeDTO
import co.proexe.domain.model.TvProgramme
import retrofit2.http.GET

interface ProgrammeApi {
    @GET("GG8C")
    suspend fun getProgramme(): List<TvProgrammeDTO>
}