package com.worldvisit.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("https://www.monwebservice.com/")
//    Toujours fournir une url de base se terminant par "/“ !
        .baseUrl("https://restcountries.eu/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}