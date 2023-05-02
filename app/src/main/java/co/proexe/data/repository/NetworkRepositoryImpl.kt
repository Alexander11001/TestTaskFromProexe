package co.proexe.data.repository

import co.proexe.data.api.ProgrammeApi
import co.proexe.data.dto.toTvProgramme
import co.proexe.domain.model.TvProgramme
import co.proexe.domain.repositories.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val programmeApi: ProgrammeApi) :
    NetworkRepository {

    override suspend fun getProgrammesList(): List<TvProgramme> {
        val dtoList = programmeApi.getProgramme()
        return dtoList.toTvProgramme()
    }
}