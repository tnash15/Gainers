package com.example.apigainers.network

import com.example.apigainers.model.Response
import io.reactivex.Observable
import retrofit2.http.GET



interface StService {

    @GET(END_POINT)
    fun getStock() : Observable<List<Response>>
    @GET(END_POINT_Quote)
    fun getQuote(): Observable<List<Response>>


}
