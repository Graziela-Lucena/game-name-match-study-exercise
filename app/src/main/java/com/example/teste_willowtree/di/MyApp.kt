package com.example.teste_willowtree.di

import android.app.Application
import com.example.teste_willowtree.controller.ProfilesViewModel
import com.example.teste_willowtree.data.remote.RetrofitInstance
import com.example.teste_willowtree.data.remote.RetrofitInterface
import com.example.teste_willowtree.data.repository.ProfilesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            androidLogger()
            modules(main)
        }
    }
}

val main = module {
    single { RetrofitInstance.getRetrofitInstance() }
    single { RetrofitInstance.getService(RetrofitInterface::class.java, get()) }
    single { ProfilesRepository(get()) }
    viewModel { ProfilesViewModel(get()) }
}