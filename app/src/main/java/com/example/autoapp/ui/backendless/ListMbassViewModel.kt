package com.example.autoapp.ui.backendless

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoapp.domain.BackendLessRepository
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import com.example.autoapp.data.model.AutoList

class ListMbassViewModel(private val repository : BackendLessRepository) : ViewModel() {

    val auto = MutableLiveData<List<AutoList>>()

    fun fetchAutos() {
        ioToUi(
            io = {
                val result = repository.getAllAuto()
                result
            },
            ui = {
                auto.value = it
            }
        )
    }

}