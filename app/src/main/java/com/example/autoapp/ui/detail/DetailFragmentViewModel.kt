package com.example.autoapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.domain.AutoRepository
import com.example.autoapp.utils.extensions.viewModel.ioToUi

class DetailFragmentViewModel(private val autoRepository: AutoRepository) : ViewModel() {

    val autoDetail = MutableLiveData<List<AutoDetail>>()

    fun fetchAutosDetail() {
        ioToUi(
            io = {
                val result = autoRepository.getAutoDetail()
                result
            },
            ui = {
                autoDetail.value = it
            }
        )
    }
}