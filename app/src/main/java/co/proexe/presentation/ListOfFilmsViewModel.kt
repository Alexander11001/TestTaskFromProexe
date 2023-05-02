package co.proexe.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.proexe.data.infrastructure.SharedPreferencesUtil
import co.proexe.data.repository.NetworkRepositoryImpl
import co.proexe.domain.model.TvProgramme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListOfFilmsViewModel @Inject constructor(
    private val networkRepository: NetworkRepositoryImpl,
    val sharedPreferencesUtil: SharedPreferencesUtil
) :
    ViewModel() {

    private val _programmes = MutableLiveData<List<TvProgramme>>()
    val programmes: LiveData<List<TvProgramme>> = _programmes

    init {
        fetchProgrammes()
    }

    private fun fetchProgrammes() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = networkRepository.getProgrammesList()
                _programmes.postValue(result)
            }
        }
    }

    fun addProgrammeToFavorites(tvProgrammeId: Int) {
        val favoriteProgramIds = sharedPreferencesUtil.loadFavoritePrograms().toMutableSet()
        favoriteProgramIds.add(tvProgrammeId)
        sharedPreferencesUtil.saveFavoritePrograms(favoriteProgramIds)
    }

    fun removeProgrammeFromFavorites(tvProgrammeId: Int) {
        val favoriteProgramIds = sharedPreferencesUtil.loadFavoritePrograms().toMutableSet()
        favoriteProgramIds.remove(tvProgrammeId)
        sharedPreferencesUtil.saveFavoritePrograms(favoriteProgramIds)
    }

    fun sortProgrammes(programmes: List<TvProgramme>): List<TvProgramme> {
        val favoriteProgramIds = sharedPreferencesUtil.loadFavoritePrograms()
        val favoriteProgrammes = mutableListOf<TvProgramme>()
        val nonFavoriteProgrammes = mutableListOf<TvProgramme>()

        for (programme in programmes) {
            if (favoriteProgramIds.contains(programme.id)) {
                favoriteProgrammes.add(programme)
            } else {
                nonFavoriteProgrammes.add(programme)
            }
        }

        favoriteProgrammes.sortBy { it.startTime }
        nonFavoriteProgrammes.sortBy { it.id }

        return favoriteProgrammes + nonFavoriteProgrammes
    }
}