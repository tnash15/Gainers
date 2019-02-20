package com.example.apigainers.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.apigainers.App
import com.example.apigainers.R
import com.example.apigainers.model.Response
import com.example.apigainers.ui.di.DaggerHomeComponent
import com.example.apigainers.ui.di.DaggerQuoteComponent
import com.example.apigainers.ui.di.QuoteModule
import kotlinx.android.synthetic.main.second_activity.*
import javax.inject.Inject


class SecondActivity : AppCompatActivity(), QuoteContract.View {



    @Inject
    lateinit var quotePresenter: QuoteContract.QuotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        DaggerQuoteComponent.builder()
            .appComponent((application as App).getComponent())
            .quoteModule(QuoteModule(this))
            .build().inject(this)



        btnResults.setOnClickListener {
            quotePresenter.getQuote(etSymbol.text.toString())
        }

    }
    override fun showQuote(results: Response) {
       tvResults.text = results.symbol

    }
    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}