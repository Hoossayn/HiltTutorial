package com.example.hilttutorial.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.hilttutorial.R
import com.example.hilttutorial.data.db.entities.User
import com.example.hilttutorial.ui.auth.LoginListener
import com.example.hilttutorial.ui.auth.LoginViewModel
import com.example.hilttutorial.utils.SharedPreferenceHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(),LoginListener {

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginViewModel.loginListener = this

        login.setOnClickListener {
            userLogin()
        }
    }

    private fun userLogin() {
        val email = edt_email.text.toString()
        val password = edt_password.text.toString()

        loginViewModel.loginUser(email, password)
    }

    override fun onStarted() {
        login_progressBar.visibility = View.VISIBLE
    }

    override fun onSuccess(user: User) {
        sharedPreferenceHelper.setStringPreference("userFirstName", user.firstName.toString())
        Toast.makeText(this, user.email, Toast.LENGTH_SHORT).show()
        login_progressBar.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        login_progressBar.visibility = View.GONE
    }
}