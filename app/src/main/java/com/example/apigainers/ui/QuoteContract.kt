package com.example.apigainers.ui

import com.example.apigainers.model.Response

interface QuoteContract {

    interface View{
        fun showQuote(results: Response)
        fun showError(message: String)
    }

    interface QuotePresenter {
        fun getQuote(symbol: String)
    }
}

