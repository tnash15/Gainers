package com.example.apigainers.di

import com.example.apigainers.network.StService
import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class])
    @Singleton

    interface AppComponent {
        fun stService(): StService
    }