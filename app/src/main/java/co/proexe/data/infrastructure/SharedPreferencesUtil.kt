package co.proexe.data.infrastructure

import android.content.SharedPreferences

class SharedPreferencesUtil(private val sharedPreferences: SharedPreferences) {

    fun saveFavoritePrograms(favoriteProgramIds: Set<Int>) {
        sharedPreferences.edit()
            .putStringSet(FAVORITE_PROGRAMS_KEY, favoriteProgramIds.map { it.toString() }.toSet())
            .apply()
    }

    fun loadFavoritePrograms(): Set<Int> {
        return sharedPreferences.getStringSet(FAVORITE_PROGRAMS_KEY, emptySet())?.map { it.toInt() }
            ?.toSet() ?: emptySet()
    }

    fun isProgrammeFavorite(programmeId: Int): Boolean {
        val favoriteProgramIds = loadFavoritePrograms()
        return favoriteProgramIds.contains(programmeId)
    }

    companion object {
        private const val FAVORITE_PROGRAMS_KEY = "favorite_programs"
    }
}