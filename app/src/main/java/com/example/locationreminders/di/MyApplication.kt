package com.example.locationreminders.di

import android.app.Application
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        startKoin {
            // Passa o contexto da aplicação
            androidContext(this@MyApplication)

            // Carrega o módulo de dependências
            modules(appModule)
        }
    }
}