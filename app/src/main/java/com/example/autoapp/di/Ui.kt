package com.example.autoapp.di

import com.example.autoapp.ui.detail.DetailFragment
import com.example.autoapp.ui.detail.DetailFragmentViewModel
import com.example.autoapp.ui.main.MainFragment
import com.example.autoapp.ui.main.MainFragmentViewModel
import com.example.autoapp.ui.main.SelectFragment
import com.example.autoapp.ui.backendless.ListMbaasFragment
import com.example.autoapp.ui.backendless.ListMbassViewModel
import com.example.autoapp.ui.saveAutoMbass.SaveAutoMbaasFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    factory { MainFragment() }
    factory { DetailFragment() }
    factory { SelectFragment() }
    factory { SaveAutoMbaasFragment() }
    factory { ListMbaasFragment() }
}

val fragmentViewModelModule = module {
    viewModel { MainFragmentViewModel(get()) }
    viewModel { DetailFragmentViewModel(get()) }
    viewModel { ListMbassViewModel(get()) }
}