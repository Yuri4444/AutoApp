package com.example.autoapp.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoapp.data.model.Auto
import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.domain.BackendLessRepository
import com.example.autoapp.utils.extensions.viewModel.ioToUi

class CreateFragmentViewModel(private val backendLessRepository: BackendLessRepository) : ViewModel() {

    val auto = MutableLiveData<AutoDetail>()


//    fun setNewAuto() {
//        ioToUi(
//            io = {
//                val result = backendLessRepository.getAllAuto()
//                result
//            },
//            ui = {
//                auto.value = it
//            }
//        )
//    }

}