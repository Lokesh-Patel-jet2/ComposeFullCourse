package com.example.composablefull.userList

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {

    @GET("users")
    suspend fun getUsers() : List<User>
}


object RetrofitInstance{
    val api : ApiService by lazy{
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}