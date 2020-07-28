package com.example.hilttutorial.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0

@Entity
data class User(
    val bio:String? = null,
    val city:String? = null,
    val email:String? = null,
    val firstName:String? = null,
    val image_url:String? = null,
    val resume_url:String? = null,
    val userid:String? = null
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}