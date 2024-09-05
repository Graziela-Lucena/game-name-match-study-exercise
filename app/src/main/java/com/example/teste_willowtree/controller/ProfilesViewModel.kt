package com.example.teste_willowtree.controller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teste_willowtree.data.models.WorkersData
import com.example.teste_willowtree.data.repository.ProfilesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfilesViewModel(private val repository: ProfilesRepository) : ViewModel() {
    private val _profiles = MutableLiveData<List<WorkersData>>()
    private val _loading = MutableLiveData<Boolean>()
    val profiles: LiveData<List<WorkersData>> = _profiles
    val loading: LiveData<Boolean> = _loading

    fun loadProfiles() = viewModelScope.launch(Dispatchers.IO) {
        var shuffledList = repository.fetchProfiles().shuffled().take(6)

        _loading.postValue(true)
        _profiles.postValue(shuffledList)
        _loading.postValue(false)

    }
}