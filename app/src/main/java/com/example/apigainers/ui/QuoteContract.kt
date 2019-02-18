package com.example.apigainers.ui

import com.example.apigainers.model.Response

interface QuoteContract {

    interface View{
        fun showQuote(results: List<Response>)
        fun showError(message: String)
        fun showResults(result: String)
    }

    interface QuotePresenter {
        fun getQuote(symbol: String)
    }
}

