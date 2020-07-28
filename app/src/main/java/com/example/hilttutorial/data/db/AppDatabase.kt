package com.example.hilttutorial.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilttutorial.data.db.entities.User

@Database(
    entities = [User:: class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getUserDao(): UserDao
}