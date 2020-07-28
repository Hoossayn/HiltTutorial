package com.example.hilttutorial.data.repository

import androidx.lifecycle.LiveData
import com.example.hilttutorial.data.db.AppDatabase
import com.example.hilttutorial.data.db.entities.User
import com.example.hilttutorial.data.network.MyApiHelper
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiHelper: MyApiHelper, private val db: AppDatabase) {

    suspend fun loginUser(email: String, password: String) = apiHelper.loginUser(email, password)

    suspend fun getLoggedInUser(jwt : String) = apiHelper.getLoggedInUser(jwt)


    suspend fun saveUserToDb(user: User) = db.getUserDao().updateOrInsert(user)
    fun getUser() = db.getUserDao().getUser()
    suspend fun deleteUser(user: LiveData<User>) = db.getUserDao().deleteUser()

}