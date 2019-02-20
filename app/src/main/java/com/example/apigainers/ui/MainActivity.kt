package com.example.apigainers.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.apigainers.App
import com.example.apigainers.R
import com.example.apigainers.ui.di.HomeModule
import com.example.apigainers.model.Response
import com.example.apigainers.ui.di.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_activity.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {


    private val APIAdapter = APIAdapter()

    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = APIAdapter

       // btnGainers.setOnClickListener {
        homePresenter.getStock()
     //   }

        btnQuote.setOnClickListener {
            val intent = Intent( this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
    override fun showStock(results: List<Response>) {
        APIAdapter.setData(results)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}


