package co.proexe.data.api

import co.proexe.data.dto.TvProgrammeDTO
import retrofit2.http.GET

interface ProgrammeApi {
    @GET("GG8C")
    suspend fun getProgramme(): List<TvProgrammeDTO>
}