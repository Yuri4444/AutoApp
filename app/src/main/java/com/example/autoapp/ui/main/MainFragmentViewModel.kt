package com.example.autoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.autoapp.data.AutoModel
import com.example.autoapp.domain.AutoRepository
import org.koin.dsl.module

val mainFragmentViewModel = module {
    factory { MainFragmentViewModel(get()) }
}

class MainFragmentViewModel(private val autoRepository: AutoRepository) : ViewModel() {

    val auto: LiveData<List<AutoModel>> = liveData {
        emit(autoRepository.getAuto())
    }

}