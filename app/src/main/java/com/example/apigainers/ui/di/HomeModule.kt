package com.example.apigainers.ui.di

import com.example.apigainers.network.StService
import com.example.apigainers.ui.HomeContract
import com.example.apigainers.ui.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View){

    @HomeScope
    @Provides
    fun provideHomePresenter(Service: StService): HomeContract.Presenter{
        return HomePresenter(Service, view)
    }
}