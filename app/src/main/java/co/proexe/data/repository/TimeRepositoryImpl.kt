package co.proexe.data.repository

import co.proexe.R
import co.proexe.domain.model.DayTile
import co.proexe.domain.repositories.TimeRepository
import java.util.*
import kotlinx.coroutines.delay

class TimeRepositoryImpl : TimeRepository {

    override suspend fun getDayTiles() {
        delay(100)
        listOf(
            DayTile(addDaysToCurrentCalendar(-2), R.string.day_before_yesterday),
            DayTile(addDaysToCurrentCalendar(-1), R.string.yesterday),
            DayTile(addDaysToCurrentCalendar(0), R.string.today),
            DayTile(addDaysToCurrentCalendar(1), R.string.tomorrow),
            DayTile(addDaysToCurrentCalendar(2), R.string.day_after_tomorrow)
        )
    }

    override fun addDaysToCurrentCalendar(amount: Int): Long {
        val cal = getCurrentCalendar()
        cal.add(Calendar.DAY_OF_YEAR, amount)
        return cal.time.time
    }

    override fun getCurrentTime() = getCurrentCalendar().time

    override fun getCurrentCalendar() = Calendar.getInstance()
}