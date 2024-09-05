package com.example.teste_willowtree.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun getRetrofitInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl("https://namegame.willowtreeapps.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun <T> getService(serviceClass: Class<T>, retrofit: Retrofit): T {
        return retrofit.create(serviceClass)
    }
}