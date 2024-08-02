package com.mili.taejin.data.remote

import com.mili.taejin.model.Headline
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
            @Query("country") country: String,
            @Query("apiKey") apiKey: String,
    ): Response<Headline>

}
