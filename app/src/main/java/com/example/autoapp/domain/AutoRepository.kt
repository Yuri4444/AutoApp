package com.example.autoapp.domain

import com.example.autoapp.data.Api

class AutoRepository(private val api: Api) {
    suspend fun getAuto() = api.getAllAuto()
    suspend fun getAutoDetail() = api.getDetailAuto()
}