package com.example.sprint6.Model.Remote

import com.example.sprint6.Model.Remote.FromInternet.Phones
import com.example.sprint6.Model.Remote.FromInternet.PhonesDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneApi {

    @GET("products")
    suspend fun fechPhoneList(): Response<List<Phones>>


    @GET("details/{id}")
    suspend fun fechPhoneDetail(@Path("id")id:String): Response <PhonesDetail>
}