package com.example.teste_willowtree.data.remote

import com.example.teste_willowtree.data.models.WorkersDataList
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("/api/v1.0/profiles")
    suspend fun getProfiles(): WorkersDataList
}