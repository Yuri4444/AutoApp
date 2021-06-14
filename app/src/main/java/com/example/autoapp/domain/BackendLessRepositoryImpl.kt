package com.example.autoapp.domain

import com.backendless.Backendless
import com.backendless.persistence.DataQueryBuilder
import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.data.net.Api


class BackendLessRepositoryImpl {

//    var autoDetails2 = mutableListOf<AutoDetails2>()






//    fun updateCar(id: String) {
//        autoDetails2.filter { it.id == id }
//    }

    suspend fun getByIdCar(id: String, image: String, title: String, producer: String, model: String, year: String ) : AutoDetail {

        val auto = AutoDetail()
        auto.id = id
        auto.image = image
        auto.title = title
        auto.producer = producer
        auto.model = model
        auto.year = year

//        Backendless.Data.of(AutoDetail::class.java).save(auto)

       return Backendless.Data.of(AutoDetail::class.java).findFirst()




    }


}