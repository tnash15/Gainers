package com.example.apigainers.network

import com.example.apigainers.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface StService {

    @GET(END_POINT)
    fun getStock() : Observable<List<Response>>


    @GET("stock/{symbol}/quote")
    fun getQuote(@Path( "symbol")symbol:String) : Observable<Response>


}
