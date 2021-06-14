package com.example.autoapp.di

import com.example.autoapp.ui.change.ChangeFragment
import com.example.autoapp.ui.change.ChangeFragmentViewModel
import com.example.autoapp.ui.create.CreateFragment
import com.example.autoapp.ui.create.CreateFragmentViewModel
import com.example.autoapp.ui.detail.DetailFragment
import com.example.autoapp.ui.detail.DetailFragmentViewModel
import com.example.autoapp.ui.main.MainFragment
import com.example.autoapp.ui.main.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    factory { MainFragment() }
    factory { DetailFragment() }
    factory { CreateFragment() }
    factory { ChangeFragment() }
}

val fragmentViewModelModule = module {
    viewModel { MainFragmentViewModel(get()) }
    viewModel { DetailFragmentViewModel(get()) }
    viewModel { CreateFragmentViewModel() }
    viewModel { ChangeFragmentViewModel() }
}