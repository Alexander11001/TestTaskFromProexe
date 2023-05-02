package co.proexe.domain.repositories

import co.proexe.domain.model.TvProgramme

interface NetworkRepository {

    suspend fun getProgrammesList(): List<TvProgramme>
}