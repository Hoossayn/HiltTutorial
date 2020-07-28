package com.example.hilttutorial.ui.auth

import com.example.hilttutorial.data.db.entities.User

interface LoginListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message:String)
}