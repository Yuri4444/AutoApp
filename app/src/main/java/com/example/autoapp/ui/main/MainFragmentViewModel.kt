package com.example.autoapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoapp.data.model.Auto
import com.example.autoapp.domain.AutoRepository
import com.example.autoapp.utils.extensions.viewModel.ioToUi

class MainFragmentViewModel(private val autoRepository: AutoRepository) : ViewModel() {

    val auto = MutableLiveData<List<Auto>>()

    fun fetchAutos() {
        ioToUi(
            io = {
                val result = autoRepository.getAuto()
                result
            },
            ui = {
                auto.value = it
            }
        )
    }
}