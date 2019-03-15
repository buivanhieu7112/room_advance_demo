package com.example.roomdatabasewithrxjava.data.source.local.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.roomdatabasewithrxjava.data.source.local.persistence.UserDatabase.Companion.DATABASE_VERSION
import com.example.roomdatabasewithrxjava.data.source.model.Pet
import com.example.roomdatabasewithrxjava.data.source.model.User

@Database(entities = [User::class, Pet::class], version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(DateTypeConvert::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_VERSION = 4
        const val DATABASE_NAME = "User-database"
        private var userDatabase: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            if (userDatabase == null) {
                userDatabase = Room.databaseBuilder(context, UserDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build()
                return userDatabase as UserDatabase
            }
            return userDatabase as UserDatabase
        }
    }
}
