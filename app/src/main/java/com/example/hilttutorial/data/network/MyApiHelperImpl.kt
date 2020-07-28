package com.example.hilttutorial.data.network

import com.example.hilttutorial.data.response.LoginResponse
import com.example.hilttutorial.data.response.LoginUser
import retrofit2.Response
import javax.inject.Inject

class MyApiHelperImpl@Inject constructor(
    private val myApi: MyApi
): MyApiHelper {

    override suspend fun loginUser(
        email: String,
        password: String
    ): Response<LoginResponse> = myApi.userLogin(email, password)

    override suspend fun getLoggedInUser(
        jwt : String
    ): Response<LoginUser> =   myApi.getLoggedInUser("Bearer $jwt")
}