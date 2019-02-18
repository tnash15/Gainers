package com.example.apigainers.ui

import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.apigainers.model.Response
import kotlinx.android.synthetic.main.second_activity.*


class SecondActivity : AppCompatActivity(), QuoteContract.View {


    override fun showQuote(results: List<Response>) {
        tvResults.getQuote(etSymbol.text.toString())
    }

    override fun showResults(result: String) {}

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun TextView.getQuote(toString: String){

    }
}