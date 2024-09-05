package com.example.teste_willowtree.data.repository

import com.example.teste_willowtree.data.remote.RetrofitInterface

class ProfilesRepository(private val api: RetrofitInterface) {
    suspend fun fetchProfiles() = api.getProfiles()
}