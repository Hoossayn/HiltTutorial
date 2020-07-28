package com.example.hilttutorial.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilttutorial.data.repository.UserRepository
import com.example.hilttutorial.utils.NetworkHelper
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(
    private val repository: UserRepository,
    private val networkHelper: NetworkHelper
): ViewModel() {

    var loginListener: LoginListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun loginUser(email:String, password:String){
        viewModelScope.launch{
            loginListener?.onStarted()
            if(networkHelper.isNetworkConnected()){
                repository.loginUser(email, password).let {
                    if (it.isSuccessful){
                        val jwt = it.body()?.jwt
                        repository.getLoggedInUser(jwt!!).let {
                            if (it.isSuccessful){
                                repository.saveUserToDb(it.body()!!.User)
                                loginListener?.onSuccess(it.body()!!.User)
                            }else{
                                loginListener?.onFailure(it.errorBody().toString())
                            }

                        }
                    }
                }
            }else {loginListener?.onFailure("Network Error: Check internet connection")}
        }
    }
}