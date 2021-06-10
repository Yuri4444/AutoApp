package com.example.autoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.autoapp.data.AutoModel
import com.example.autoapp.domain.AutoRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainFragmentViewModelModule = module {
    viewModel { MainFragmentViewModel(get()) }
}

class MainFragmentViewModel(private val autoRepository: AutoRepository) : ViewModel() {

    val auto: LiveData<List<AutoModel>> = liveData {
        emit(autoRepository.getAuto())
    }

//    fun fetchAutos() {
//        val result = autoRepository.getAuto()
//        auto.value = result
//    }



}