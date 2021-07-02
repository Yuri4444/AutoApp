package com.example.autoapp.di

import com.example.autoapp.domain.AutoRepository
import com.example.autoapp.domain.BackendLessRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val autoRepositoryModule = module {
    factory { AutoRepository(get()) }
    factory(named("New")) { BackendLessRepository(get()) }
}