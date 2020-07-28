package com.example.hilttutorial.data.network

import com.example.hilttutorial.data.response.LoginResponse
import com.example.hilttutorial.data.response.LoginUser
import retrofit2.Response

interface MyApiHelper {

    suspend fun loginUser(
        email:String,
        password:String
    ): Response<LoginResponse>

    suspend fun getLoggedInUser(
        jwt: String
    ): Response<LoginUser>
}