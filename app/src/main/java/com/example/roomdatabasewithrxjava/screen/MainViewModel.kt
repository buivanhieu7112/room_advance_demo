package com.example.roomdatabasewithrxjava.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.roomdatabasewithrxjava.data.source.UserRepository
import com.example.roomdatabasewithrxjava.data.source.local.UserLocalDataSource
import com.example.roomdatabasewithrxjava.data.source.local.persistence.UserDatabase
import com.example.roomdatabasewithrxjava.data.source.model.User
import java.util.*

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository =
        UserRepository.getInstance(UserLocalDataSource.getInstance(UserDatabase.getInstance(application).userDao()))

    fun addUser(){
        val user = User(1,"a","a@gmail.com","2000", Calendar.getInstance().time)
        inserUser(user)
    }

    fun inserUser(vararg user: User) {
        userRepository.insertUser(*user)
    }

    fun getUserById(id: Int) : User? {
        return userRepository.getUserById(id)
    }

    fun updateUser(vararg user: User) {
        userRepository.updateUser(*user)
    }

    fun deleteUser(id: Int) {
        userRepository.deleteUser(id)
    }
}
