package com.example.openinapp.ui

import androidx.lifecycle.ViewModel
import com.example.openinapp.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    val data = mainRepository.getDetails()
}