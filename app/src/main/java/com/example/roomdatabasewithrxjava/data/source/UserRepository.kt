package com.example.roomdatabasewithrxjava.data.source

import androidx.room.Transaction
import com.example.roomdatabasewithrxjava.data.UserDataSource
import com.example.roomdatabasewithrxjava.data.source.local.UserLocalDataSource
import com.example.roomdatabasewithrxjava.data.source.model.Pet
import com.example.roomdatabasewithrxjava.data.source.model.User
import com.example.roomdatabasewithrxjava.data.source.model.UserAndAllPet

class UserRepository private constructor(private val userLocalDataSource: UserLocalDataSource) : UserDataSource {
    override fun getUserAndPet(): UserAndAllPet {
        return userLocalDataSource.getUserAndPet()
    }

    override fun insertPet(vararg pet: Pet) {
        userLocalDataSource.insertPet(*pet)
    }

    override fun getPetsForUser(user_id: Int): MutableList<Pet>? {
        return userLocalDataSource.getPetsForUser(user_id)
    }

    override fun getUserById(id: Int): User? {
        return userLocalDataSource.getUserById(id)
    }

    override fun insertUser(vararg user: User) {
        userLocalDataSource.insertUser(*user)
    }

    override fun deleteUser(id: Int) {
        userLocalDataSource.deleteUser(id)
    }

    override fun updateUser(vararg user: User) {
        userLocalDataSource.updateUser(*user)
    }

    companion object {
        private var sInstance: UserRepository? = null
        fun getInstance(userLocalDataSource: UserLocalDataSource): UserRepository {
            if (sInstance == null) {
                return UserRepository(userLocalDataSource)
            }
            return sInstance as UserRepository
        }
    }

    @Transaction
    fun replace(user: User, id: Int) {
        userLocalDataSource.insertUser(user)
        userLocalDataSource.getUserById(id)
    }
}
