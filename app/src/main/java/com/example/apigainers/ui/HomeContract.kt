package com.example.apigainers.ui

import com.example.apigainers.model.Response

interface HomeContract {

    interface View {
        fun showStock(results: List<Response>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getStock()
    }
}