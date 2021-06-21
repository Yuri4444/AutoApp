package com.example.autoapp.domain

import com.backendless.Backendless
import com.example.autoapp.data.model.Auto
import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.data.net.ApiMbaas

class BackendLessRepository(private val apiMbaas: ApiMbaas) {

//    suspend fun getAuto(): List<Auto> {
//
//    }

//    suspend fun getByIdCar(id: String): AutoDetail {
//        val auto = AutoDetail()
//        auto.id = id
//        return Backendless.Data.of(AutoDetail::class.java).findFirst()
//    }

    suspend fun setAuto() : AutoDetail {
        return apiMbaas.setNewAuto()

    }

    suspend fun getAllAuto() = apiMbaas.getAutoList()


}