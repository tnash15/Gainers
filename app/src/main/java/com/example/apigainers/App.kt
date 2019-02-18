package com.example.apigainers

import android.app.Application
import com.example.apigainers.di.AppComponent
import com.example.apigainers.di.DaggerAppComponent


class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    fun getComponent() = appComponent
}