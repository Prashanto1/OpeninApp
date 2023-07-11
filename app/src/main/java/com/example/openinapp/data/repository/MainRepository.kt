package com.example.openinapp.data.repository

import com.example.openinapp.data.network.ApiService
import com.example.openinapp.utils.toResultFlow
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {
    fun getDetails() = toResultFlow {
        apiService.getDetails()
    }
}