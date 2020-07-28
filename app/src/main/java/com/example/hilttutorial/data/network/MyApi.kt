package com.example.hilttutorial.data.network

import com.example.hilttutorial.data.response.LoginResponse
import com.example.hilttutorial.data.response.LoginUser
import retrofit2.Response
import retrofit2.http.*

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email")email:String,
        @Field("password") password:String
    ): Response<LoginResponse>


    @GET("getuser")
    suspend fun getLoggedInUser(
        @Header("Authorization") jwt:String
    ): Response<LoginUser>

}