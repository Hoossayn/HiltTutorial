package com.example.hilttutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hilttutorial.R
import com.example.hilttutorial.utils.SharedPreferenceHelper
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userFirstName = sharedPreferenceHelper.getStringPreference("userFirstName")
        firstName.text = "Welcome $userFirstName"
    }
}