package com.example.roomdatabasewithrxjava.data.source.local

import com.example.roomdatabasewithrxjava.data.UserDataSource
import com.example.roomdatabasewithrxjava.data.source.local.persistence.UserDao
import com.example.roomdatabasewithrxjava.data.source.model.Pet
import com.example.roomdatabasewithrxjava.data.source.model.User

class UserLocalDataSource private constructor(private val userDao: UserDao) : UserDataSource {
    override fun insertPet(vararg pet: Pet) {
        userDao.insertPet(*pet)
    }

    override fun getPetsForUser(user_id: Int) {
        userDao.getPetsForUser(user_id)
    }

    override fun getUserById(id: Int): User? {
        return userDao.getUserById(id)
    }

    override fun insertUser(vararg user: User) {
        userDao.insertUser(*user)
    }

    override fun deleteUser(id: Int) {
        userDao.deleteUser(id)
    }

    override fun updateUser(vararg user: User) {
        userDao.updateUser(*user)
    }

    companion object {
        private var sInstance: UserLocalDataSource? = null
        fun getInstance(userDao: UserDao): UserLocalDataSource {
            if (sInstance == null) {
                return UserLocalDataSource(userDao)
            }
            return sInstance as UserLocalDataSource
        }
    }
}
