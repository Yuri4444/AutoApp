package com.example.autoapp.ui.change

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.domain.BackendLessRepository

class ChangeFragmentViewModel(private val repositoryImpl: BackendLessRepository) : ViewModel() {

    val auto = MutableLiveData<AutoDetail>()

//    fun fetchData(id: String, image: String, title: String, producer: String, model: String, year: String) {
//        ioToUi(
//            io = {
//                val result = repositoryImpl.getByIdCar(id, image, title, producer, model, year)
//                result
//            },
//            ui = {
//                auto.value = it
//            }
//        )
//    }

}