package com.example.autoapp.di

import com.example.autoapp.ui.detail.DetailFragment
import com.example.autoapp.ui.detail.DetailFragmentViewModel
import com.example.autoapp.ui.main.MainFragment
import com.example.autoapp.ui.main.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    factory { MainFragment() }
    factory { DetailFragment() }
}

val fragmentViewModelModule = module {
    viewModel { MainFragmentViewModel(get()) }
    viewModel { DetailFragmentViewModel(get()) }
}