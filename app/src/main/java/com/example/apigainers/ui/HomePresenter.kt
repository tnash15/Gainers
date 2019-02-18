package com.example.apigainers.ui

import com.example.apigainers.network.StService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter (

    private val stService: StService,
    private val view: HomeContract.View) : HomeContract.Presenter{

    private val compositeDisposable = CompositeDisposable()

    override fun getStock() {
        compositeDisposable.add(stService.getStock()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({view.showStock(it)}, { throwable -> view.showError(throwable.message!!) }))

    }

}

