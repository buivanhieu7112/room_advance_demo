package com.example.roomdatabasewithrxjava.data

import com.example.roomdatabasewithrxjava.data.source.model.Pet
import com.example.roomdatabasewithrxjava.data.source.model.User
import com.example.roomdatabasewithrxjava.data.source.model.UserAndAllPet

interface UserDataSource {
    fun getUserById(id: Int): User?

    fun insertUser(vararg user: User)

    fun deleteUser(id: Int)

    fun updateUser(vararg user: User)

    fun insertPet(vararg pet: Pet)

    fun getPetsForUser(user_id: Int): MutableList<Pet>?

    fun getUserAndPet(): UserAndAllPet
}
