package com.example.apigainers.ui.di

import com.example.apigainers.di.AppComponent
import com.example.apigainers.ui.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject (mainActivity: MainActivity)
}