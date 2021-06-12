package com.example.autoapp.di

import com.example.autoapp.domain.AutoRepository
import org.koin.dsl.module

val autoRepositoryModule = module {
    factory { AutoRepository(get()) }
}