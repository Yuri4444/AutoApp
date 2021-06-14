package com.example.autoapp.domain

import com.example.autoapp.data.model.Auto
import com.example.autoapp.data.net.Api

class AutoRepository(private val api: Api) {
//    suspend fun getAuto() = api.getAllAuto().map { it.auto }.run {
//        mutableListOf<Auto>().apply {
//            this@run.forEach {
//                addAll(it)
//            }
//        }
//    }.toList()

    suspend fun getAuto() = api.getAllAuto()
    suspend fun getAutoDetail() = api.getDetailAuto()
}