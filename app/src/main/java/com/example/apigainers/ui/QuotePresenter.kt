package com.example.apigainers.ui

import com.example.apigainers.network.StService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class QuotePresenter (

    private val stService: StService,
    private val view: QuoteContract.View) : QuoteContract.QuotePresenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getQuote(symbol: String) {
        compositeDisposable.add(stService.getQuote()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ view.showQuote(it) }, { throwable -> view.showError(throwable.message!!) })
        )

    }
}