package com.example.trackapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackapp.db.Run
import com.example.trackapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository):ViewModel()
{

    val runSortedByDate = mainRepository.getAllRunsSortedByDate()



    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }


}