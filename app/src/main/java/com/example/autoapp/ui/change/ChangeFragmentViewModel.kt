package com.example.autoapp.ui.change

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.domain.BackendLessRepositoryImpl
import com.example.autoapp.utils.extensions.viewModel.ioToUi

class ChangeFragmentViewModel(private val repositoryImpl: BackendLessRepositoryImpl) : ViewModel() {

    val auto = MutableLiveData<AutoDetail>()

    fun fetchData(id: String, image: String, title: String, producer: String, model: String, year: String) {
        ioToUi(
            io = {
                val result = repositoryImpl.getByIdCar(id, image, title, producer, model, year)
                result
            },
            ui = {
                auto.value = it
            }
        )
    }

}