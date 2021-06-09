package com.example.autoapp.domain

import com.example.autoapp.data.Api
import org.koin.dsl.module

val autoRepositoryModule = module {
    factory { AutoRepository(get()) }
}

class AutoRepository(private val api: Api) {
    suspend fun getAuto() = api.getAllAuto()
}