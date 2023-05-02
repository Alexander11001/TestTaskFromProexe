package co.proexe.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.proexe.data.repository.NetworkRepositoryImpl
import co.proexe.domain.model.TvProgramme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListOfFilmsViewModel @Inject constructor(private val networkRepository: NetworkRepositoryImpl) :
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
}