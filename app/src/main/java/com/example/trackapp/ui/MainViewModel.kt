package com.example.trackapp.ui

import androidx.lifecycle.ViewModel
import com.example.trackapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository):ViewModel()
{


}