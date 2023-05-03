package co

import android.content.SharedPreferences
import co.proexe.data.infrastructure.SharedPreferencesUtil
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class SharedPreferencesUtilTest {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesEditor: SharedPreferences.Editor
    private lateinit var sharedPreferencesUtil: SharedPreferencesUtil

    @Before
    fun setUp() {
        sharedPreferences = Mockito.mock(SharedPreferences::class.java)
        sharedPreferencesEditor = Mockito.mock(SharedPreferences.Editor::class.java)
        sharedPreferencesUtil = SharedPreferencesUtil(sharedPreferences)

        `when`(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor)
        `when`(
            sharedPreferencesEditor.putStringSet(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any()
            )
        ).thenReturn(sharedPreferencesEditor)
    }

    @Test
    fun saveFavoriteProgramsTest() {
        val favoriteProgramIds = setOf(1, 2, 3)
        sharedPreferencesUtil.saveFavoritePrograms(favoriteProgramIds)

        Mockito.verify(sharedPreferencesEditor).putStringSet(
            SharedPreferencesUtil.FAVORITE_PROGRAMS_KEY,
            favoriteProgramIds.map { it.toString() }.toSet()
        )
        Mockito.verify(sharedPreferencesEditor).apply()
    }

    @Test
    fun loadFavoriteProgramsTest() {
        val favoriteProgramIds = setOf(1, 2, 3)
        `when`(
            sharedPreferences.getStringSet(
                SharedPreferencesUtil.FAVORITE_PROGRAMS_KEY,
                emptySet()
            )
        ).thenReturn(favoriteProgramIds.map { it.toString() }.toSet())

        val result = sharedPreferencesUtil.loadFavoritePrograms()

        assertEquals(favoriteProgramIds, result)
    }

    @Test
    fun isProgrammeFavoriteTest() {
        val favoriteProgramIds = setOf(1, 2, 3)
        `when`(
            sharedPreferences.getStringSet(
                SharedPreferencesUtil.FAVORITE_PROGRAMS_KEY,
                emptySet()
            )
        ).thenReturn(favoriteProgramIds.map { it.toString() }.toSet())

        val result = sharedPreferencesUtil.isProgrammeFavorite(2)

        assertTrue(result)
    }
}