package com.example.roomdatabasewithrxjava.data.source.local.persistence

import androidx.room.*
import com.example.roomdatabasewithrxjava.data.source.model.Pet
import com.example.roomdatabasewithrxjava.data.source.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE id = :userId")
    fun getUserById(userId: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: User)

    @Update
    fun updateUser(vararg user: User)

    @Query("DELETE FROM User WHERE id = :userId")
    fun deleteUser(userId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPet(vararg pet: Pet)

    @Query("SELECT * FROM Pet WHERE user_id = :userId")
    fun getPetsForUser(userId: Int)
}
