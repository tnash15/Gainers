package com.example.apigainers.ui.di

import com.example.apigainers.network.StService
import com.example.apigainers.ui.QuoteContract
import com.example.apigainers.ui.QuotePresenter
import dagger.Module
import dagger.Provides

@Module
class QuoteModule(private val view: QuoteContract.View){


    @QuoteScope
    @Provides
    fun provideQuotePresenter(Service: StService): QuoteContract.QuotePresenter{
    return QuotePresenter(Service,view)}
}
