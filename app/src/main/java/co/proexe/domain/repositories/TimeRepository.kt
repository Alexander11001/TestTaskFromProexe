package co.proexe.domain.repositories

import java.util.*

interface TimeRepository {

    suspend fun getDayTiles()

    fun addDaysToCurrentCalendar(amount: Int): Long

    fun getCurrentTime(): Date?

    fun getCurrentCalendar(): Calendar?
}