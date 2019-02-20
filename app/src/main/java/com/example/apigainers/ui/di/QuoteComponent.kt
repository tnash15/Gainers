package com.example.apigainers.ui.di

import com.example.apigainers.di.AppComponent
import com.example.apigainers.ui.SecondActivity
import dagger.Component



@Component(dependencies = [AppComponent::class], modules = [QuoteModule::class])
@QuoteScope
interface QuoteComponent{
    fun inject (secondActivity: SecondActivity)
}


